# Spring Context Tests

This project is a Java-based web application built with Spring Framework, designed to simulate a simple e-commerce system. It includes basic services for handling `Products` and managing a `Cart`. The application uses Spring's Dependency Injection, prototypes, and singleton scopes to demonstrate object management. Unit tests are implemented to verify the functionality of the services.

## Features

- **Product Service**: Manages products, allowing CRUD operations on products.
- **Cart Service**: Manages a shopping cart with functions to add, remove products, and calculate total cost.
- **Spring Dependency Injection**: Utilizes `@Autowired`, `@PostConstruct`, and `@Component` annotations for component management.
- **JUnit 5 Tests**: Includes test cases for verifying the correct functionality of product and cart operations.

## Components

### Models

1. **Product**
   - Fields: `id`, `name`, `price`
   - Represents a product with unique `id`, `name`, and `price` (BigDecimal).
   
2. **Cart**
   - Field: `cartMap` (`Map<Product, Integer>`)
   - Stores products in a map with the quantity of each product.
   - Methods:
     - `addProduct(Product product, Integer quantity)`: Adds a specified quantity of a product.
     - `delProduct(Product product, Integer quantity)`: Removes a specified quantity of a product.
     - `getSum()`: Returns the total cost of products in the cart.

### Repositories

1. **ProductRepository**
   - Stores and manages `Product` instances.
   - Methods:
     - `findAll()`: Retrieves all products.
     - `saveOrUpdate(Product product)`: Saves or updates a product.
     - `findById(Long id)`: Finds a product by its ID.
     - `deleteById(Long id)`: Deletes a product by its ID.
   - Uses `@PostConstruct` to initialize with sample products.

### Services

1. **CartService**
   - Interface defining methods to manipulate the cart, such as adding/removing products and calculating total.

2. **ProductService**
   - Interface defining product-related operations like retrieving, saving, and deleting products.

3. **CartServiceImpl**
   - Implements `CartService`, includes methods for cart manipulation and calculations.
   - Uses `@Autowired` for dependency injection.

4. **ProductServiceImpl**
   - Implements `ProductService`, includes methods for product management.

## Setup

1. **Install Dependencies**: Ensure Maven is installed, and the required dependencies (`JUnit`, `Spring`) are specified in `pom.xml`.
2. **Database Configuration**: No database is needed; `ProductRepository` uses an in-memory `Map` to store products.
3. **Build**: Run `mvn clean install` to build the project.

## Running Tests

This project uses JUnit 5 for unit testing. To run the tests:

1. Execute the tests from the command line:
   ```bash
   mvn test
   ```
2. Each test case in `ProductServiceTest` and `CartServiceTest` verifies specific functionality:
   - Product retrieval, addition, and deletion.
   - Cart manipulation, such as adding/removing items and calculating the total.

## Example Test Scenarios

- **ProductServiceTest**:
  - `testGetProductList()`: Verifies that products can be retrieved.
  - `testSaveOrUpdate()`: Tests that a product can be saved or updated.
  - `testGetProductById()`: Verifies retrieval of a product by ID.
  - `testDeleteById()`: Confirms that a product can be deleted by ID.

- **CartServiceTest**:
  - `testAddProductToCart()`: Ensures products are added to the cart with correct quantities.
  - `testRemoveProductFromCart()`: Confirms products can be removed from the cart.
  - `testGetSumOfCart()`: Validates the calculation of the total cart value.
  - `testGetProductQuantity()`: Verifies the correct quantity of a product in the cart.

## Troubleshooting

- **Dependency Conflicts**: Ensure unique versions for each dependency in `pom.xml`.
- **No Tests Run**: Verify that test classes are named with `*Test` suffix and are located in the `src/test/java` directory.

## License

This project is open-source and available under the MIT License [LICENSE](LICENSE).
