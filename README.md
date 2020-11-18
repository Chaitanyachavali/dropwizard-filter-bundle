# dropwizard-filter-bundle
A small dropwizard bundle to filter resources based on mode supplied

## What does it do?
This bundle essentially restricts/allows the API based on mode supplied

#### Modes available:
- `READ_ONLY`
  - Allows only `GET` resources
- `READ_WRITE`
  - Allows all resources
  
#### Additional options:
- There might cases where we end up having a read-only API with `POST` method, cases when we have a request body for filter params and so on. In these scenarios you can annotate specific resource with `@ReadOnlyAPI` which discounts the `HttpMethod` and allows all requests even incase of `READ_ONLY` mode.   


## Usage
Add the repository 
```xml
<repository>
    <id>clojars</id>
    <name>Clojars repository</name>
    <url>https://clojars.org/repo</url>
</repository>
```

Add the dependency
```xml
<dependency>
    <groupId>com.chaitanyachavali.dropwizard</groupId>
    <artifactId>dropwizard-filters-bundle</artifactId>
    <version>1.0.0</version>
</dependency>
```

Add the bundle to your application
```
@Override
public void initialize(Bootstrap bootstrap) {
    bootstrap.addBundle(new ResourceFilterBundle<ApplicationConfiguration>() {
        @Override
        public FilterMode withMode(ApplicationConfiguration conf) {
            return conf.getFilterMode();
        }
    });
}
```