> <p style="text-align: right;">
>  🇺🇸 <a href="README.md">English version</a>
> </p>

# Explorador de Usuários do GitHub (Projeto feito durante processo seletivo da Electrolux BR)

## Sobre Este Projeto

Este aplicativo Android foi desenvolvido como parte do processo seletivo para a vaga de Desenvolvedor Android na Electrolux BR. O desenvolvimento inicial ocorreu durante uma sessão de _live coding_ de 2 horas com um entrevistador, seguida por um período de 24 horas para finalização e entrega.

O desafio principal foi construir um aplicativo que se integra com a API do GitHub para:
1.  Listar usuários do GitHub.
2.  Exibir informações detalhadas quando um usuário específico é selecionado na lista.

## Funcionalidades

*   **Listagem de Usuários**: Exibe uma lista de usuários do GitHub obtida através da API do GitHub.
*   **Detalhes do Usuário**: Mostra informações mais detalhadas para um usuário selecionado, incluindo:
    *   Avatar/Foto de Perfil
    *   Nome (se disponível)
    *   Bio (se disponível)
*   **Carregamento de Imagens**: Carrega e exibe avatares de usuários de forma eficiente usando Glide.
*   **Clean Architecture**: Estruturado seguindo os princípios da Clean Architecture para promover separação de responsabilidades, testabilidade e manutenibilidade.

## Arquitetura e Tecnologias

Este projeto foi construído seguindo as melhores práticas modernas de desenvolvimento Android:

*   **Linguagem de Programação**: Kotlin
*   **Arquitetura**:
    *   Clean Architecture (Camadas: Domain, Data, Presentation)
    *   MVVM (Model-View-ViewModel) para a camada de apresentação
*   **Injeção de Dependência**: Koin
*   **Rede (Networking)**:
    *   Retrofit: Para realizar chamadas à API do GitHub.
    *   OkHttp: (Normalmente usado pelo Retrofit para requisições HTTP)
*   **Carregamento de Imagens**: Glide
*   **Programação Assíncrona**: Kotlin Coroutines
*   **Manipulação de Dados**:
    *   Repository Pattern: Media entre as fontes de dados (rede, banco de dados local) e a camada de domínio.
    *   Use Cases (Casos de Uso): Encapsulam lógicas de negócio específicas.
*   **Testes**: Testes Unitários utilizando MockK

## Estrutura do Projeto

O projeto é organizado em pacotes que refletem as camadas da Clean Architecture:

*   `presentation`: Contém a UI (Activities, ViewModels).
*   `domain`: Contém Casos de Uso (Interactors) e modelos/entidades em Kotlin puro.
*   `data`: Contém implementações de Repositório, definições de serviço da API (Retrofit), interfaces de fontes de dados.
*   `core`: Custom view para carregar imagens, utils compartilhados e extensions.

## 📸 Screenshot
![Home](screenshots/user-list.png)
