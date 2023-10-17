## MICRO SERVIÇO DE CADASTRO DE TARIFAS ## 

#### Este microserviço foi construído para gerenciar informações de tarifas, separadas em módulos regulatórios e contábeis. Cada tarifa contém detalhes sobre tabelas de preços, registros adicionais e condições especiais. O serviço permite criar, listar, buscar por ID e excluir tarifas, com validações de dados, tratamento de exceções e detecção de conflitos e dependências. ####

Classes e suas funções:

1.	AdmTariffConstants:
   
    •	Classe de constantes que define os módulos regulatórios e contábeis;

3.	AdmTariffController:
   
    •	Controla as solicitações HTTP relacionadas a tarifas;
    •	Oferece endpoints para criar, listar, buscar e excluir tarifas;
    •	Trata conversão de DTO para entidade;
    •	Lida com exceções e retorna respostas HTTP apropriadas.

5.	AdmTariffDTO:
   
    •	Representa o objeto de transferência de dados (DTO) para tarifas;
    •	Contém informações sobre módulo, data e listas de tabelas, registros adicionais e condições especiais;

7.	AdmTariffTableDTO, AdmAdditionalRecordDTO, AdmSpecialConditionDTO:
   
    •	DTOs para tabelas, registros adicionais e condições especiais, respectivamente;
    •	Contêm informações relevantes para cada tipo de tarifa.

9.	AdmTariffEntity, AdmTariffTableEntity, AdmAdditionalRecordEntity, AdmSpecialConditionEntity:
    
    •	Entidades que representam as tarifas, tabelas, registros adicionais e condições especiais;
    •	São mapeadas para o banco de dados e armazenam os detalhes das tarifas.

11.	AdmTariffRepository:
    
    •	Repositório para acessar as entidades de tarifa no banco de dados.

13.	AdmTariffService:
    
    •	Contém a lógica de negócios para criar, listar, buscar e excluir tarifas;
    •	Realiza validações de dados, verifica conflitos e dependências;
    •	Trata exceções, como ValidationException, ConflictException, DependecyException, DataAcessException, para fornecer feedback e respostas apropriadas.
   	
15.	Exceptions e Tratamento:
    
    •	ValidationException: Lançada se os dados da tarifa não forem válidos;
    •	ConflictException: Lançada se uma tarifa com critérios semelhantes já existir;
    •	DependecyException: Lançada se a tarifa possui dependências e não pode ser excluída;
    •	DataAcessException (Spring Data): Tratamento de erros no banco de dados.

#### Este microserviço oferece controle sobre tarifas, com tratamento de exceções para garantir a integridade dos dados e fornecer respostas adequadas aos clientes que acessam as operações disponíveis. Além disso, ele mantém informações detalhadas sobre tarifas para os módulos regulatórios e contábeis #### 
