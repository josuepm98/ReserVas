# ReserVas
Para poder correr la aplicación en un sistema necesitarás Expo, IntelliJ y mySQL Workbench.

Comenzando por el Backend, en el workbench tendrás que correr el script que hay en ese proyecto y después crear el usuario taes con privilegios :
create user 'taes'@'%' identified by 'password';
grant all privileges on reservas.* to 'taes'@'%'; 
A continuación, desde IntelliJ tienes que ejecutar la Aplicación.

Para el Frontend desde el proyecto con una terminal es necesario hacer "npm i" para instalar todo lo necesario y después "npm start"

Con esto debería de abrirse en el navegador una pestaña de Expo, clicamos en "Run in browser" y podremos acceder a la página web.
