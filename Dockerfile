# Verwende Eclipse Temurin JDK 21 als Basisimage
FROM eclipse-temurin:21

# Setze User
ENV USER=root

# Installiere erforderliche Pakete
RUN apt-get update && apt-get install -y \
    maven \
    xvfb \
    tightvncserver \
    novnc \
    websockify \
    python3 \
    && rm -rf /var/lib/apt/lists/*

# Setze Arbeitsverzeichnis
WORKDIR /app

# Kopiere pom.xml und src
COPY pom.xml .
COPY src ./src

# Baue das Projekt
RUN mvn clean package -DskipTests

# Kopiere die gebaute JAR
RUN cp target/*.jar app.jar

# Erstelle ein Start-Script
RUN echo '#!/bin/bash\n\
export USER=root\n\
# Setze VNC Passwort (verwende env var oder default)\n\
mkdir -p ~/.vnc\n\
echo "${VNC_PASSWORD:-password}" | vncpasswd -f > ~/.vnc/passwd\n\
chmod 600 ~/.vnc/passwd\n\
\n\
# Starte VNC Server\n\
vncserver :1 -geometry 1280x720 -depth 24\n\
\n\
# Setze DISPLAY\n\
export DISPLAY=:1\n\
\n\
# Starte noVNC (websockify für Web-Zugriff)\n\
websockify --web=/usr/share/novnc/ 6080 localhost:5901 &\n\
\n\
# Starte die Anwendung\n\
java -jar app.jar\n' > start.sh && chmod +x start.sh

# Exponiere Ports
EXPOSE 5901 6080

# Starte das Script
CMD ["./start.sh"]
