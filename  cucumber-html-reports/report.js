$(document).ready(function() {var formatter = new CucumberHTML.DOMFormatter($('.cucumber-report'));formatter.uri("src/test/resources/features/EnviarCorreo.feature");
formatter.feature({
  "name": "Enviar correo",
  "description": "  Para comunicarme con mis contactos de correo electronico\n  Como usuario de Gmail\n  Quiero enviar correos electronicos",
  "keyword": "Característica"
});
formatter.scenarioOutline({
  "name": ": Enviando un correo en Gmail",
  "description": "",
  "keyword": "Esquema del escenario"
});
formatter.step({
  "name": "Estoy en la bandeja de entrada de Gmail con mi \u003cusername\u003e y \u003cpass\u003e",
  "keyword": "Dado "
});
formatter.step({
  "name": "Redacto un correo con \u003cdestinatario\u003e \u003casunto\u003e y \u003ccontenido\u003e",
  "keyword": "Cuando "
});
formatter.step({
  "name": "Deberia poder enviar mi correo",
  "keyword": "Entonces "
});
formatter.step({
  "name": "Deberia ver el mensaje de correo enviado",
  "keyword": "Entonces "
});
formatter.examples({
  "name": ":",
  "description": "",
  "keyword": "Ejemplos",
  "rows": [
    {
      "cells": [
        "username",
        "pass",
        "destinatario",
        "asunto",
        "contenido"
      ]
    },
    {
      "cells": [
        "ab",
        "hola",
        "olivacarlos92@gmail.com",
        "Prueba",
        "usuario y pass malo"
      ]
    },
    {
      "cells": [
        "pruebascaoliva",
        "testingsura",
        "olivacarlos92@gmail.com",
        "Prueba",
        "Prueba que pasaria"
      ]
    }
  ]
});
formatter.scenario({
  "name": ": Enviando un correo en Gmail",
  "description": "",
  "keyword": "Esquema del escenario"
});
formatter.step({
  "name": "Estoy en la bandeja de entrada de Gmail con mi ab y hola",
  "keyword": "Dado "
});
formatter.match({});
formatter.result({
  "status": "undefined"
});
formatter.step({
  "name": "Redacto un correo con olivacarlos92@gmail.com Prueba y usuario y pass malo",
  "keyword": "Cuando "
});
formatter.match({});
formatter.result({
  "status": "undefined"
});
formatter.step({
  "name": "Deberia poder enviar mi correo",
  "keyword": "Entonces "
});
formatter.match({});
formatter.result({
  "status": "undefined"
});
formatter.step({
  "name": "Deberia ver el mensaje de correo enviado",
  "keyword": "Entonces "
});
formatter.match({});
formatter.result({
  "status": "undefined"
});
formatter.scenario({
  "name": ": Enviando un correo en Gmail",
  "description": "",
  "keyword": "Esquema del escenario"
});
formatter.step({
  "name": "Estoy en la bandeja de entrada de Gmail con mi pruebascaoliva y testingsura",
  "keyword": "Dado "
});
formatter.match({});
formatter.result({
  "status": "undefined"
});
formatter.step({
  "name": "Redacto un correo con olivacarlos92@gmail.com Prueba y Prueba que pasaria",
  "keyword": "Cuando "
});
formatter.match({});
formatter.result({
  "status": "undefined"
});
formatter.step({
  "name": "Deberia poder enviar mi correo",
  "keyword": "Entonces "
});
formatter.match({});
formatter.result({
  "status": "undefined"
});
formatter.step({
  "name": "Deberia ver el mensaje de correo enviado",
  "keyword": "Entonces "
});
formatter.match({});
formatter.result({
  "status": "undefined"
});
});