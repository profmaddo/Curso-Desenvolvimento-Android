package foo.maddo.appaula03bancodedadossqlite;

import org.junit.runner.RunWith;
import org.junit.runners.Suite;
import org.junit.runners.Suite.SuiteClasses;

/**
 * Suíte de testes para todas as classes do modelo.
 * Esta suíte executa todos os testes unitários e de integração das classes:
 * - EnderecoTest
 * - FornecedorTest
 * - ProdutoTest
 * - ModelIntegrationTest
 */
@RunWith(Suite.class)
@SuiteClasses({
    EnderecoTest.class,
    FornecedorTest.class,
    ProdutoTest.class,
    ModelIntegrationTest.class
})
public class ModelTestSuite {
    // Esta classe não precisa de métodos.
    // A anotação @SuiteClasses define quais classes de teste executar.
} 