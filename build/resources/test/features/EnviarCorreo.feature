# language: es
Característica: Enviar correo
  Para comunicarme con mis contactos de correo electronico
  Como usuario de Gmail
  Quiero enviar correos electronicos

  Esquema del escenario: : Enviando un correo en Gmail
    Dado Estoy en la bandeja de entrada de Gmail con mi <username> y <pass>
    Cuando Redacto un correo con <destinatario> <asunto> y <contenido>
    Entonces Deberia poder enviar mi correo
    Entonces Deberia ver el mensaje de correo enviado
    Ejemplos: :
  | username        | pass        | destinatario            | asunto | contenido           |
  | ab              | hola        | olivacarlos92@gmail.com | Prueba | usuario y pass malo |
  | pruebascaoliva  | testingsura | olivacarlos92@gmail.com | Prueba | Prueba que pasaria  |

