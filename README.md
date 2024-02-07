# JAVA-API-REST-Cardapio

Este exercício criado com orientação de vídeos do YouTube. Se diz respeito a uma criação de API na linguagem JAVA. O mesmo possui métodos/endpoints criados para os métodos de GET, POST, PUT e DELETE.

O exercício está relacionado as linguagens:
- JAVA;
- MySQL.

Framework:
- Spring Boot.

O exercício possui:
- Criação do Modelo MVC;
- Injeção de Dependências;
- Encapsulamento de Dados;
- Ações comentadas para auxílio;
- Validações de abertura e encerramento de conexão com banco de dados;
- CURLs para teste via Postman.

Ajustado em 27/01/2024
- Notação adicionada"@CrossOrigin(origins = "http://localhost:5173")". Foi necessário devido a política de navegadores, implantada pelos navegadores, para evitar que um site faça solicitações para outro site, a partir de uma fonte/origem diferente, sem a permissão necessária. Pesquisei a respeito de "CORS" no ChatGPT e qual seria a solução ideal. O mesmo informou que seria abrir essa notação no back-end para validar o mapeamento dos end-poits.
- Foi necessário aplicar esse mapeamento em todos os endpoints para as futuras requisições via React que serão aplicadas via próximo exercício.

Ajustado em 31/01/2024
 - Foi necessário criar a classe "CorsConfig.java" para aceitar todos os tipos de requisição requisitadas por meio do Front End. Não foi o suficiente, ter realizado o processo de notação @CrossOrigin de forma individual. Com isso, foi dado permissão para todas as requisições HTTP que poderá ser realizado por meio do Front End desenvolvido por outro exercício em meu perfil, "REACT-Cardapio".

Ajustado em 04/02/2024
 - A configuração dos CORS para métodos DELETE e PUT foram atualizados conforme necessidade. Sem os ajustes, em que são encontrados no Controller, não é possível realizar a operação de requisição dos métodos.

Atenciosamente,

Yan B. Falcão

https://www.linkedin.com/in/yanboninifalcao/
