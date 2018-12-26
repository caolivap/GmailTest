# language: es
Característica: Enviar correo
  Antecedentes:
  Para comunicarme con mis contactos de correo electronico
  Como usuario de Gmail
  Quiero enviar correos electronicos
  Esquema del escenario: : Enviando un correo en Gmail
    Dado Estoy en la bandeja de entrada de Gmail con usuario <remitente> y contrasena <passRemitente>
    Cuando Redacto un correo para <destinatario> con asunto <asunto> y contenido <contenido>
    Entonces Deberia poder enviar mi correo
    Entonces Deberia poder ver en la cuenta <destinatario> con pass <passDestino> el correo con remitente <remitente> asunto <asunto> y contenido <contenido>
    Ejemplos: :
  | remitente                   | passRemitente | destinatario                  | asunto   | contenido               |  passDestino |
  | pruebascaoliva@gmail.com    | testingsura   | pruebadestinatario@gmail.com  | Prueba   | Prueba que pasaria      |  testingsura |
  | pruebascaoliva@gmail.com    | testingsura   | pruebadestinatario@gmail.com  | Prueba 2 | 2 Prueba que pasaria    |  testingsura |
  | pruebascaoliva@gmail.com    | testingsura   | pruebadestinatario@gmail.com  | Prueba 3 | 3 Prueba que pasaria    |  testingsura |
  | pruebascaoliva@gmail.com    | testingsura   | pruebadestinatario@gmail.com  | Prueba 4 | 4 Prueba que pasaria    |  testingsura |

