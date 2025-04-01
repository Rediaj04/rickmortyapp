# 🚀 Rick and Morty App

<div style="text-align: center;">
    <img src="https://i.pinimg.com/474x/47/38/f8/4738f815006b44970af63ed185c68663.jpg" alt="Rick and Morty" style="max-width: 400px; margin: 0 auto;">
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

---
⭐️ Hecho con ❤️ por Rediaj04 