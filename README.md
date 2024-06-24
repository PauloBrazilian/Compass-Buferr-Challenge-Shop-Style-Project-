# Compass-Buferr-Challenge-Shop-Style-Project-

## Projeto Shop Style: Loja Virtual com Arquitetura de Micro-serviços

### Visão Geral

O **Shop Style** é uma loja física de roupas que está em processo de expansão para o ambiente digital, criando uma loja online para aumentar seu alcance e atender melhor seus clientes. Para isso, foi decidido adotar uma arquitetura de micro-serviços, dividindo o sistema em componentes independentes que se comunicam entre si. Este projeto tem como objetivo implementar essa solução, fornecendo uma plataforma robusta e escalável para gerenciar todos os aspectos do negócio online.

### Arquitetura do Sistema

A arquitetura do sistema é baseada em micro-serviços, cada um responsável por uma parte específica do negócio. Os principais micro-serviços são: **customer, catalog, payment, order, audit, e bff-shop**. Cada micro-serviço terá suas próprias responsabilidades, funcionalidades, e validações.

### Descrição dos Micro-serviços

#### 1. MS Customer

O micro-serviço **customer** é responsável pelo gerenciamento dos dados dos clientes. Isso inclui desde a criação de novos usuários, atualização de perfis, até a gestão dos endereços associados a cada cliente. Além disso, este serviço cuida da autenticação dos usuários, garantindo que somente pessoas autorizadas tenham acesso às suas contas.

#### 2. MS Catalog

O micro-serviço **catalog** gerencia todo o inventário de produtos. Isso envolve a criação, atualização e remoção de produtos, bem como a gestão de suas variantes (SKUs), categorias e mídias associadas. O catálogo também é responsável por ouvir mensagens via RabbitMQ para atualizar o estoque em tempo real conforme os pedidos são processados.

#### 3. MS Payment

O micro-serviço **payment** é responsável por gerenciar os métodos de pagamento disponíveis na plataforma. Ele permite a criação, atualização e remoção de métodos de pagamento, além de processar os pagamentos dos pedidos. Este serviço também escuta mensagens via RabbitMQ para processar pagamentos e atualizar o status dos mesmos.

#### 4. MS Order

O micro-serviço **order** gerencia os pedidos de compra. Ele é responsável por validar os dados do cliente e a disponibilidade dos produtos antes de finalizar um pedido. Além disso, ele se integra com o serviço de pagamento para processar os pagamentos e atualiza o status dos pedidos com base nos resultados do processamento. O MS Order também envia mensagens para o catálogo para atualizar o estoque dos produtos.

#### 5. MS Audit

O micro-serviço **audit** é responsável por auditar todos os eventos que ocorrem durante o processamento de um pedido. Ele registra todas as interações entre os micro-serviços de pedidos, pagamentos e catálogo, fornecendo uma visão detalhada e completa de todo o fluxo de processamento de pedidos.

#### 6. MS BFF-Shop

O micro-serviço **BFF-Shop** (Backend for Frontend) serve como um ponto de entrada único para que os clientes possam interagir com a plataforma. Ele integra todas as funcionalidades dos outros micro-serviços, proporcionando uma interface única e coesa para os usuários. Este serviço garante a autenticação e autorização dos usuários via JWT, facilitando a comunicação segura entre os clientes e os micro-serviços internos.
