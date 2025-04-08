# 🚀 Rick and Morty App

<div style="text-align: center; margin: 20px 0;">
    <img src="https://i.pinimg.com/474x/47/38/f8/4738f815006b44970af63ed185c68663.jpg" 
         alt="Rick and Morty" 
         style="max-width: 400px; width: 100%; height: auto; border-radius: 10px; box-shadow: 0 4px 8px rgba(0,0,0,0.1);">
</div>

Una aplicación web interactiva que te permite explorar el universo de Rick and Morty. Desarrollada con Spring Boot y Thymeleaf, esta aplicación te permite navegar por todos los personajes de la serie, ver sus detalles y explorar sus episodios.

## 🌟 Características

- 📱 Interfaz moderna y responsive
- 🔍 Lista completa de personajes
- 👤 Detalles detallados de cada personaje
- 📺 Lista de episodios por personaje
- 🎨 Diseño inspirado en la serie
- ⚡ Rendimiento optimizado

## 🛠️ Tecnologías Utilizadas

- Java 17
- Spring Boot 3.2.3
- Thymeleaf
- Bootstrap 5.3.0
- Maven
- Rick and Morty API

## 📋 Prerrequisitos

- Java 17 o superior
- Maven 3.6 o superior
- Git

## 🚀 Instalación

1. Clona el repositorio:
```bash
git clone https://github.com/Rediaj04/rickmortyapp.git
cd rickmortyapp
```

2. Compila el proyecto:
```bash
./mvnw clean install
```

3. Ejecuta la aplicación:
```bash
./mvnw spring-boot:run
```

4. Abre tu navegador y visita:
```
http://localhost:8082
```

## 🎮 Uso

1. En la página principal, verás una lista de todos los personajes de Rick and Morty
2. Haz clic en cualquier personaje para ver sus detalles
3. En la página de detalles podrás ver:
   - Imagen del personaje
   - Estado (Vivo, Muerto o Desconocido)
   - Especie
   - Género
   - Origen
   - Ubicación actual
   - Lista de episodios en los que aparece

## 🛡️ Estructura del Proyecto

```
rickmortyapp/
├── src/
│   ├── main/
│   │   ├── java/
│   │   │   └── com/rickmorty/rickmortyapp/
│   │   │       ├── controller/
│   │   │       ├── model/
│   │   │       ├── service/
│   │   │       └── RickMortyAppApplication.java
│   │   └── resources/
│   │       ├── static/
│   │       └── templates/
│   └── test/
├── pom.xml
└── README.md
```

## 🤝 Contribuir

Las contribuciones son bienvenidas. Por favor, sigue estos pasos:

1. Haz un Fork del proyecto
2. Crea una rama para tu feature (`git checkout -b feature/AmazingFeature`)
3. Commit tus cambios (`git commit -m 'Add some AmazingFeature'`)
4. Push a la rama (`git push origin feature/AmazingFeature`)
5. Abre un Pull Request

## 📝 Licencia

Este proyecto está bajo la Licencia MIT - ver el archivo [LICENSE](LICENSE) para más detalles.

## 🙏 Agradecimientos

- [Rick and Morty API](https://rickandmortyapi.com/) por proporcionar los datos
- [Spring Boot](https://spring.io/projects/spring-boot) por el framework
- [Bootstrap](https://getbootstrap.com/) por los estilos

## Solución de Problemas Comunes

### 1. Error de Versión de Java

**Síntoma:**
```
Fatal error compiling: error: release version 17 not supported
```

**Solución:**
1. Verifica que tienes Java 17 instalado:
```bash
java -version
```

2. Si no tienes Java 17, instálalo:
```bash
sudo apt update
sudo apt install -y temurin-17-jdk
```

3. Configura JAVA_HOME:
```bash
export JAVA_HOME=/usr/lib/jvm/temurin-17-jdk-amd64
export PATH=$JAVA_HOME/bin:$PATH
```

4. Limpia la caché de Maven y recompila:
```bash
rm -rf ~/.m2/repository/org/apache/maven/plugins/maven-compiler-plugin/
./mvnw clean install -U
```

### 2. Puerto en Uso

**Síntoma:**
```
Failed to start bean 'webServerStartStop': Port 8082 is already in use
```

**Solución:**
1. Encuentra el proceso que está usando el puerto:
```bash
sudo lsof -i :8082
```

2. Termina el proceso:
```bash
sudo kill -9 <PID>
```

3. Intenta iniciar la aplicación nuevamente:
```bash
./mvnw spring-boot:run
```

### 3. Error de Configuración del Proyecto

**Síntoma:**
```
Project configuration is not up-to-date with pom.xml, requires an update
```

**Solución:**
1. Actualiza las dependencias de Maven:
```bash
./mvnw clean install -U
```

2. Si estás usando VS Code:
   - Presiona `Ctrl+Shift+P`
   - Escribe "Java: Update Project Configuration"
   - Selecciona la opción para actualizar la configuración

### 4. Problemas con la API

**Síntoma:**
```
Error al obtener los personajes: Connection refused
```

**Solución:**
1. Verifica tu conexión a internet
2. Asegúrate de que la API está disponible:
```bash
curl https://rickandmortyapi.com/api/character/1
```

3. Si el problema persiste, espera unos minutos y vuelve a intentar

### 5. Problemas de Visualización

**Síntoma:**
- La especie no se muestra en la lista de personajes
- Los estilos no se cargan correctamente

**Solución:**
1. Limpia la caché del navegador
2. Verifica que la URL de la API es correcta en `application.properties`:
```properties
rickandmorty.api.base-url=https://rickandmortyapi.com/api
```

3. Reinicia la aplicación:
```bash
./mvnw spring-boot:run
```

---
<div style="text-align: center; margin-top: 30px;">
    <p style="font-size: 1.2em; margin-bottom: 15px;">⭐️ Hecho con ❤️ por Rediaj04</p>
    <img src="https://avatars.githubusercontent.com/Rediaj04" 
         alt="Rediaj04" 
         style="width: 100px; height: 100px; border-radius: 50%; box-shadow: 0 4px 8px rgba(0,0,0,0.1);">
</div> 