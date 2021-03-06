# Template for Microservices with Hexagonal Architecture

![your-UML-diagram-name](http://www.plantuml.com/plantuml/proxy?cache=no&src=https://raw.githubusercontent.com/johnjqc/hexagonal-architecture-ports-adapters/main/documentation/diagram-project-components.iuml)

### Adapter Module: Primary / Driving Adapter

The primary adapters are the way to entrance into the domain, these adapters make use of the input ports, for this reason are named how Driving Adapters.

This adapters are defined in the infrastructure layer and you can define all the configurations that you need to make work it.

So for example if you have an REST Controller, you might need security with oAuth, you might need define an controller advice for manage controlled responses, all this features must be defined in the module of this adapter.

In this template you can find an example of how this adapter should be designed to handle exceptions and error codes generated by the core, and this REST adapter was configured with OpenAPI to create the controllers with the YAML definition.

### Package Naming

The package for the Primary adapter must have the structure com...infrastructure.adapater.in.(REST, SOAP, CLI, etc)

## Adapter Module: Secondary / Driven Adapters

The secondary adapters are the way out of the domain, these adapters make use of the output ports, for this reason are named how Driven Adapters.

This adapters are defined in the infrastructure layer and you can define all the configurations that you need to make work it.

So for example if you have one adapter to a data base, you need the JPA repositories, JPA entity objects, but remember, the properties for this connections and datasource configuration must be have in the global properties because, the global project handle this spring configuration, and remember by application you only manage two file for properties, the application.properties and the secrets.properties.

### Package Naming 

The package for the Secondary adapter must have the structure com...infrastructure.adapater.out.(jpa, (little name third service), mail, sms, etc )

## Core Module: Domain and Application

We are defined our domain module with layer, application and domain that contains the principal hexagonal structure, remember, this module not manage dependencies of any framework, only libraries that you consider need.

The ports are domain exposed interfaces, these interfaces are implemented in classes that represent the use cases and these use cases are defined in the application layer.

### Application Layer

In this layer you must have only the implementation classes of the input port that are named use cases, this implementations are the way to entrance in your domain.

#### Use Cases

The Use Cases class is the first representation of our business logic in our code, but you must handle the least possible business logic in these classes, the business logic must be implemented mostly in the components called Aggregate, these components are part of the domain, we will talk about them later.

### Domain Layer

In our domain we can define:

- **Aggregate**: These classes handle the business logic of our domain, inject the exist ports required for its operation and if necessary they can use application services that complement their responsibilities. Example: AggregateTemplate.java

- **DomainEntity**: Do not confuse these entities with JPA entities, the domain entities must represent the data model independently of the destination where they are stored, that is, each entity has the definition of the properties as well as the restrictions and type of each data as its validations of length, nullity, characters. This domain entity should not be used as a response from the domain, that is, as a response in an input adapter, it should only be used within the domain and towards the output adapters that are in charge of persisting the data. Example: MessageDomainEntity.java

- **Ports**: In this package you must define the input and output ports on interfaces, In this package you must define the input and output ports on interfaces. Each Port must have only one method, for example if you need to integrate with 3 services, you need to define one Port per service and you only create one adapter module for all your implementations. Our port must be defined with DTO, for example: ReturnDTO nameMethod(ParamDTO paramDto)

	Example: com.jsoft.domain.port

- **Dto's**: You can create object that you need to use within the domain for the operation of your app

- **Exception**: in this package you can define your exception class and your response code class: Exceptions: To define you custom exception implement the class AbstractDomainException.java with this implementation you can make use of the custom response codes and handle it out of your domain, for example in your incoming adapters. Example: BusinessException.java Response Codes: If you need manage and response code you can implement the interface (ResponseCode.java) Example: DomainResponseCode.java

![your-UML-diagram-name](http://www.plantuml.com/plantuml/proxy?cache=no&src=https://raw.githubusercontent.com/johnjqc/hexagonal-architecture-ports-adapters/main/documentation/diagram-components.iuml)
