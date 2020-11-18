# dropwizard-filter-bundle
A small dropwizard bundle to filter resources based on mode supplied

## Usage
```
    @Override
    public void initialize(final Bootstrap...) {
        bootstrap.addBundle(new ResourceFilterBundle() {
            
            public boolean withMode() {
                return FilterMode.READ_WRITE;
            }
            
        });
    }

```