# spring-ripper

## Bean lifecycle

- Создаются BeanDefinition (xml парсится, ищутся по аннотациям или java-конфигам)
- BeanFactoryPostProcessor обрабатывают BeanDefinition
- BeanFactory начинает создавать бины
- BBP применяют postProcessBeforeInitialization
- вызывается init-метод бина
- BBP применяют postProcessAfterInitialization
- Создается событие обновление контекста, на которое можно подписаться

## Трехфазовый конструктор

- Constructor (java)
- @PostConstruct (BPP)
- @PostProxy (ContextListener)

### BeanPostProcessor

- Позволяет настраивать бины до того, как они попадают в контейнер
- У этого интерфейса 2 метода (первый вызывается до init-метода, второй - после):
    Object postProcessBeforeInitialization(Object bean, String beanName)
    Object postProcessAfterInitialization(Object bean, String beanName)
- Между ними вызывается init метод
    - init-метод
    - afterPropertiesSet
    - @PostConstruct
    
### ApplicationListener

Умеет слушать контекст спринга, т.е. все события спринга

- ContextStartedEvent (начал построение, после вызовет refresh)
- ContextStoppedEvent
- ContextRefreshedEvent
- ContextClosedEvent

Из любого ивента можно вытащить контекст


### BeanFactoryPostProcessor

Позволяет настраивать BeanDefinition, до того как BeanFactory начнет создавать бины


### ClassPathBeanDefinitionScanner

- Создает BeanDefinition, из классов, над которыми стоит @Component, или другая аннотация аннотированная @Component

### Java Config

- new AnnotationConfigApplicationContext(JavaConfig.class)
- Казалось бы его должен парсировать какой-нибудь BeanDefinitionReader, как это было с XML
- И класс его называется схоже: AnnotatedBeanDefinitionReader
- Но нет, AnnotatedBeanDefinitionReader вообще ни чего не имплементирует
- Он просто является частью ApplicationContext
- Он только регистрирует все JavaConfig


### ConfigurationClassPostProcessor (особый BeanFactoryPostProcessor)

- Обрабатывает JavaConfig'и
- Его регистрирует AnnotationConfigApplicationContext, как BeanFactoryPostProcessor
- Он создает BeanDefinition по @Bean

### Groovy Config

- new GenericGroovyApplicationContext("context.groovy")
- Парсируется GroovyBeanDefinitionReader