package foo.maddo.appaula03bancodedadossqlite;

import android.os.Bundle;
import android.util.Log;
import android.widget.Button;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import foo.maddo.appaula03bancodedadossqlite.test.CRUDTest;
import foo.maddo.appaula03bancodedadossqlite.test.JUnitTestRunner;

public class MainActivity extends AppCompatActivity {

    private CRUDTest crudTest;
    private JUnitTestRunner jUnitTestRunner;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        // Inicializar o CRUDTest
        crudTest = new CRUDTest(this);
        crudTest.abrirConexao();

        // Inicializar o JUnitTestRunner
        jUnitTestRunner = new JUnitTestRunner(this);

        // Configurar listeners dos botões
        configurarListeners();

        Log.i("MainActivity", "Aplicação iniciada - Banco de Dados SQLite");
    }

    private void configurarListeners() {
        // Botões de dados mockados
        Button btnPopularDados = findViewById(R.id.btnPopularDados);
        Button btnLimparDados = findViewById(R.id.btnLimparDados);
        Button btnEstatisticas = findViewById(R.id.btnEstatisticas);

        // Botões de testes CRUD
        Button btnTestarCRUDEndereco = findViewById(R.id.btnTestarCRUDEndereco);
        Button btnTestarCRUDFornecedor = findViewById(R.id.btnTestarCRUDFornecedor);
        Button btnTestarCRUDProduto = findViewById(R.id.btnTestarCRUDProduto);
        Button btnTestarRelacionamentos = findViewById(R.id.btnTestarRelacionamentos);

        // Botões de testes JUnit
        Button btnExecutarTodosTestes = findViewById(R.id.btnExecutarTodosTestes);
        Button btnExecutarTestesUnitarios = findViewById(R.id.btnExecutarTestesUnitarios);
        Button btnExecutarTestesIntegracao = findViewById(R.id.btnExecutarTestesIntegracao);
        Button btnExecutarSuiteCompleta = findViewById(R.id.btnExecutarSuiteCompleta);
        Button btnExecutarTestesEstatisticas = findViewById(R.id.btnExecutarTestesEstatisticas);
        Button btnVerificarDisponibilidadeTestes = findViewById(R.id.btnVerificarDisponibilidadeTestes);
        Button btnMostrarInformacoesTestes = findViewById(R.id.btnMostrarInformacoesTestes);

        // Listeners para dados mockados
        btnPopularDados.setOnClickListener(v -> {
            Log.d("MainActivity", "Botão Popular Dados clicado");
            crudTest.popularDadosMockados();
        });

        btnLimparDados.setOnClickListener(v -> {
            Log.d("MainActivity", "Botão Limpar Dados clicado");
            crudTest.limparDados();
        });

        btnEstatisticas.setOnClickListener(v -> {
            Log.d("MainActivity", "Botão Estatísticas clicado");
            crudTest.exibirEstatisticas();
        });

        // Listeners para testes CRUD
        btnTestarCRUDEndereco.setOnClickListener(v -> {
            Log.d("MainActivity", "Botão Testar CRUD Endereço clicado");
            crudTest.testarCRUDEndereco();
        });

        btnTestarCRUDFornecedor.setOnClickListener(v -> {
            Log.d("MainActivity", "Botão Testar CRUD Fornecedor clicado");
            crudTest.testarCRUDFornecedor();
        });

        btnTestarCRUDProduto.setOnClickListener(v -> {
            Log.d("MainActivity", "Botão Testar CRUD Produto clicado");
            crudTest.testarCRUDProduto();
        });

        btnTestarRelacionamentos.setOnClickListener(v -> {
            Log.d("MainActivity", "Botão Testar Relacionamentos clicado");
            crudTest.testarRelacionamentos();
        });

        // Listeners para testes JUnit
        btnExecutarTodosTestes.setOnClickListener(v -> {
            Log.d("MainActivity", "Botão Executar Todos os Testes JUnit clicado");
            jUnitTestRunner.executarTodosOsTestes();
        });

        btnExecutarTestesUnitarios.setOnClickListener(v -> {
            Log.d("MainActivity", "Botão Executar Testes Unitários clicado");
            jUnitTestRunner.executarTestesUnitarios();
        });

        btnExecutarTestesIntegracao.setOnClickListener(v -> {
            Log.d("MainActivity", "Botão Executar Testes de Integração clicado");
            jUnitTestRunner.executarTestesIntegracao();
        });

        btnExecutarSuiteCompleta.setOnClickListener(v -> {
            Log.d("MainActivity", "Botão Executar Suíte Completa clicado");
            jUnitTestRunner.executarSuiteCompleta();
        });

        btnExecutarTestesEstatisticas.setOnClickListener(v -> {
            Log.d("MainActivity", "Botão Executar Testes com Estatísticas clicado");
            jUnitTestRunner.executarTestesComEstatisticas();
        });

        btnVerificarDisponibilidadeTestes.setOnClickListener(v -> {
            Log.d("MainActivity", "Botão Verificar Disponibilidade clicado");
            jUnitTestRunner.verificarDisponibilidadeTestes();
        });

        btnMostrarInformacoesTestes.setOnClickListener(v -> {
            Log.d("MainActivity", "Botão Mostrar Informações dos Testes clicado");
            jUnitTestRunner.mostrarInformacoesTestes();
        });
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        // Fechar conexão com o banco de dados
        if (crudTest != null) {
            crudTest.fecharConexao();
        }
        Log.i("MainActivity", "Aplicação finalizada - Conexões fechadas");
    }
}