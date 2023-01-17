# This project is created using Selenide + JUnit 5 + Selenoid + Allure
## To run tests and generate Allure report:
1. run `mvn clean test`
2. run `mvn allure:serve`

## Run options:
+ By default, tests are being run with local browser binaries. To run browsers in Selenoid add `-Dmode=remote` in run configuration. Make sure to have Selenoid listeting on `http://localhost:4444`. Selenoid documentation can be found [here](https://aerokube.com/selenoid/latest/#_quick_start_guide);
+ To run tests in different browser use `-Dselenide.browser=$BROWSER`. List of supported browsers by Selenide can be found in [documentation](https://selenide.org/documentation.html). 


