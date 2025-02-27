Feature: Pet Store API User Tests

  Background:
    * url 'https://petstore.swagger.io/v2'
    * def userId = 123456
    * def userName = 'testuser'
    * def randomEmail = function(){ return 'testuser' + Math.floor(Math.random() * 10000) + '@example.com' }
    * def initialEmail = randomEmail()
    * def updatedEmail = randomEmail()

  Scenario: Crear un usuario, buscarlo, actualizarlo, buscarlo actualizado y eliminarlo
    # 1. Crear un usuario
    Given path '/user'
    And request {
      id: '#(userId)',
      username: '#(userName)',
      firstName: 'Test',
      lastName: 'User',
      email: '#(initialEmail)',
      password: 'password123',
      phone: '1234567890',
      userStatus: 1
    }
    When method post
    Then status 200
    And match response == { code: '#number', type: '#string', message: '#string' }
    And match response.message == '#string'
    
    # 2. Buscar el usuario creado
    Given path '/user', userName
    When method get
    Then status 200
    And match response == {
      id: '#(userId)',
      username: '#(userName)',
      firstName: 'Test',
      lastName: 'User',
      email: '#(initialEmail)',
      password: 'password123',
      phone: '1234567890',
      userStatus: 1
    }
    
    # 3. Actualizar el nombre y el correo del usuario
    Given path '/user', userName
    And request {
      id: '#(userId)',
      username: '#(userName)',
      firstName: 'TestUpdated',
      lastName: 'UserUpdated',
      email: '#(updatedEmail)',
      password: 'password123',
      phone: '1234567890',
      userStatus: 1
    }
    When method put
    Then status 200
    And match response == { code: '#number', type: '#string', message: '#string' }
    
    # 4. Buscar el usuario actualizado
    Given path '/user', userName
    When method get
    Then status 200
    And match response == {
      id: '#(userId)',
      username: '#(userName)',
      firstName: 'TestUpdated',
      lastName: 'UserUpdated',
      email: '#(updatedEmail)',
      password: 'password123',
      phone: '1234567890',
      userStatus: 1
    }
    
    # 5. Eliminar el usuario
    Given path '/user', userName
    When method delete
    Then status 200
    And match response == { code: '#number', type: '#string', message: '#string' }
    And match response.message == '#string'
    
    # Verificar que el usuario ya no existe
    Given path '/user', userName
    When method get
    Then status 404