# 📍 AndroidReverseGPS - Aplicativo de Localização GPS

> **Parte do Curso Desenvolvimento Android Java e Kotlin**  
> **Professor: Marco Maddo** 🎓

## 📋 Sobre o Projeto

O **AndroidReverseGPS** é um aplicativo Android que demonstra como obter e exibir a **localização GPS** do dispositivo, incluindo latitude, longitude e informações de rede. O projeto serve como exemplo prático de como implementar funcionalidades de localização em aplicativos Android, incluindo:

- **Obtenção de coordenadas GPS** (latitude e longitude)
- **Verificação de status de GPS e rede**
- **Solicitação de permissões de localização**
- **Interface para visualização de dados de localização**
- **Integração com serviços de localização do Android**

## 🎯 Funcionalidades do App

O aplicativo oferece as seguintes funcionalidades:

1. **📍 Obtenção de Localização**: Captura latitude e longitude do dispositivo
2. **🌐 Verificação de Rede**: Identifica tipo de conexão (2G, 3G, 4G)
3. **📱 Interface Visual**: Exibe dados de localização de forma clara
4. **🗺️ Visualização no Mapa**: Botão para abrir localização no mapa
5. **⚙️ Gerenciamento de Permissões**: Solicita permissões necessárias
6. **🔧 Configurações GPS**: Direciona para configurações do dispositivo

## 🏗️ Arquitetura do Projeto

### 📁 **Estrutura de Arquivos**

```
app/src/main/
├── java/foo/maddo/androidreversegps/
│   ├── MainActivity.java        # Activity principal
│   ├── GPSTracker.java         # Classe para rastreamento GPS
│   └── AppUtil.java            # Utilitários do aplicativo
├── res/
│   ├── layout/
│   │   └── activity_main.xml   # Layout da interface
│   └── values/
│       ├── strings.xml         # Strings do app
│       ├── colors.xml          # Cores
│       └── themes.xml          # Temas
└── AndroidManifest.xml         # Configuração e permissões
```

## 📱 Classes e Componentes

### 🚀 **MainActivity.java**

A **Activity Principal** que gerencia a interface e inicializa o rastreamento GPS.

```java
public class MainActivity extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);
        // Configuração da interface
    }
}
```

### 📍 **GPSTracker.java**

A **classe principal** responsável por gerenciar a localização GPS do dispositivo.

#### **Características Principais:**

- **Extends Service**: Executa como serviço em background
- **Implements LocationListener**: Recebe atualizações de localização
- **Dual Provider**: Suporta GPS e Network Provider
- **Permission Management**: Gerencia permissões de localização

#### **Propriedades Importantes:**

```java
private final Context mContext;
boolean isGPSEnabled = false;        // Status do GPS
boolean isNetworkEnabled = false;    // Status da rede
boolean canGetLocation = false;      // Pode obter localização
Location location;                   // Objeto de localização
double latitude;                     // Latitude
double longitude;                    // Longitude

// Configurações de atualização
private static final long MIN_DISTANCE_CHANGE_FOR_UPDATES = 10; // 10 metros
private static final long MIN_TIME_BW_UPDATES = 1000 * 60 * 1;  // 1 minuto
```

#### **Métodos Principais:**

1. **`getLocation()`**: Obtém a localização atual
2. **`getLatitude()`**: Retorna a latitude
3. **`getLongitude()`**: Retorna a longitude
4. **`canGetLocation()`**: Verifica se pode obter localização
5. **`showSettingsAlert()`**: Mostra diálogo para configurações
6. **`stopUsingGPS()`**: Para o rastreamento GPS

### 🛠️ **AppUtil.java**

Classe utilitária que fornece métodos auxiliares para o aplicativo.

#### **Métodos Principais:**

1. **`getNetworkClass()`**: Identifica tipo de rede (2G, 3G, 4G)
2. **`isConnectingToInternet()`**: Verifica conectividade com internet
3. **`imprimeLog()`**: Utilitário para logging

## 🔐 Permissões Necessárias

### 📄 **AndroidManifest.xml**

O aplicativo requer as seguintes permissões:

```xml
<uses-permission android:name="android.permission.INTERNET" />
<uses-permission android:name="android.permission.ACCESS_COARSE_LOCATION" />
<uses-permission android:name="android.permission.ACCESS_FINE_LOCATION" />
<uses-permission android:name="android.permission.ACCESS_NETWORK_STATE" />
<uses-permission android:name="android.permission.READ_PHONE_STATE" />
```

### 📋 **Explicação das Permissões:**

| Permissão | Função | Quando Usada |
|-----------|--------|--------------|
| **INTERNET** | Acesso à internet | Verificação de conectividade |
| **ACCESS_COARSE_LOCATION** | Localização aproximada | Localização via rede |
| **ACCESS_FINE_LOCATION** | Localização precisa | Localização via GPS |
| **ACCESS_NETWORK_STATE** | Status da rede | Verificação de conectividade |
| **READ_PHONE_STATE** | Informações do telefone | Identificação do tipo de rede |

## ⚙️ Configurações do Dispositivo

### 📱 **Configurações Necessárias**

Para que o aplicativo funcione corretamente, o usuário deve:

#### **1. Habilitar Localização**
```
Configurações > Localização > Ativar
```

#### **2. Configurar Modo de Localização**
```
Configurações > Localização > Modo > Alta precisão
```

#### **3. Permitir Permissões do App**
```
Configurações > Apps > AndroidReverseGPS > Permissões
- Localização: Permitir
- Telefone: Permitir
```

#### **4. Habilitar GPS**
```
Configurações > Localização > GPS > Ativar
```

### 🔧 **Configurações Avançadas**

#### **Para Melhor Precisão:**
- **Wi-Fi**: Manter ativado para localização por rede
- **Dados Móveis**: Ativar para localização por rede
- **Alta Precisão**: Usar GPS + Wi-Fi + dados móveis

## 📍 Como Obter Latitude e Longitude

### 🔄 **Processo de Obtenção de Localização**

#### **1. Verificação de Status**
```java
// Verifica se GPS está habilitado
isGPSEnabled = locationManager.isProviderEnabled(LocationManager.GPS_PROVIDER);

// Verifica se rede está habilitada
isNetworkEnabled = locationManager.isProviderEnabled(LocationManager.NETWORK_PROVIDER);
```

#### **2. Priorização de Providers**
1. **Network Provider** (mais rápido, menos preciso)
2. **GPS Provider** (mais lento, mais preciso)

#### **3. Solicitação de Atualizações**
```java
locationManager.requestLocationUpdates(
    LocationManager.NETWORK_PROVIDER,
    MIN_TIME_BW_UPDATES,           // 1 minuto
    MIN_DISTANCE_CHANGE_FOR_UPDATES, // 10 metros
    this
);
```

#### **4. Obtenção de Coordenadas**
```java
if (location != null) {
    latitude = location.getLatitude();
    longitude = location.getLongitude();
}
```

### 📊 **Configurações de Atualização**

| Parâmetro | Valor | Descrição |
|-----------|-------|-----------|
| **MIN_TIME_BW_UPDATES** | 60.000ms | Tempo mínimo entre atualizações |
| **MIN_DISTANCE_CHANGE_FOR_UPDATES** | 10m | Distância mínima para atualização |

## 🎨 Interface de Usuário

### 📄 **activity_main.xml**

Layout que exibe informações de localização:

#### **Componentes:**

| Componente | ID | Função |
|------------|----|--------|
| **Título** | `txtTitulo` | Explica o propósito do app |
| **Rede** | `txtRede` | Mostra tipo de rede (2G/3G/4G) |
| **Latitude** | `txtLatitude` | Exibe coordenada de latitude |
| **Longitude** | `txtLongitude` | Exibe coordenada de longitude |
| **Endereço** | `txtEndereco` | Mostra endereço (se disponível) |
| **Botão Mapa** | `btnMapa` | Abre localização no mapa |

#### **Características Visuais:**
- **Fundo preto** para contraste
- **Cores diferentes** para cada tipo de informação
- **Textos grandes** para fácil leitura
- **Layout vertical** organizado

## 🔄 Fluxo de Execução

### 📱 **Inicialização do App:**

1. **MainActivity.onCreate()** é executado
2. **Layout XML** é carregado
3. **GPSTracker** é inicializado
4. **Permissões** são verificadas
5. **Localização** é obtida

### 🔍 **Processo de Obtenção de Localização:**

1. **Verificação de Permissões**
   - `ACCESS_FINE_LOCATION`
   - `ACCESS_COARSE_LOCATION`

2. **Verificação de Providers**
   - GPS habilitado?
   - Rede habilitada?

3. **Solicitação de Localização**
   - Primeiro tenta Network Provider
   - Depois tenta GPS Provider

4. **Processamento de Dados**
   - Extração de latitude/longitude
   - Verificação de tipo de rede
   - Atualização da interface

## 🛠️ Tecnologias e Recursos Utilizados

### **Linguagem e Framework:**
- **Java**: Linguagem de programação principal
- **Android SDK**: Framework de desenvolvimento
- **LocationManager**: Gerenciamento de localização
- **LocationListener**: Recebimento de atualizações

### **Componentes de Localização:**
- **GPS_PROVIDER**: Localização via satélite
- **NETWORK_PROVIDER**: Localização via rede
- **Location**: Objeto com dados de localização
- **LocationManager**: Gerenciador de serviços de localização

### **Recursos de Interface:**
- **LinearLayout**: Layout vertical
- **TextView**: Exibição de informações
- **Button**: Ação para abrir mapa
- **Cores personalizadas**: Diferenciação visual

## 🚀 Como Executar

### **1. Configuração do Dispositivo:**
1. **Habilite a localização** nas configurações
2. **Configure para alta precisão**
3. **Ative GPS e Wi-Fi**

### **2. Configuração do App:**
1. **Clone** o repositório
2. **Abra** o projeto no Android Studio
3. **Sincronize** o Gradle
4. **Execute** em dispositivo físico (GPS necessário)

### **3. Permissões:**
1. **Conceda permissões** quando solicitado
2. **Permita acesso à localização**
3. **Permita acesso ao telefone** (para verificar rede)

## 📊 Saída Esperada

### **Interface do App:**
- **Título**: Explicação do propósito
- **Tipo de Rede**: 2G, 3G, 4G ou Desconhecida
- **Latitude**: Coordenada de latitude (ex: -23.5505)
- **Longitude**: Coordenada de longitude (ex: -46.6333)
- **Endereço**: Endereço aproximado (se disponível)
- **Botão**: "VISUALIZAR NO MAPA"

### **Logcat:**
```
D/Network: Network
D/GPS Enabled: GPS Enabled
I/AppUtil: Tipo de rede: 4G
```

## 🎯 Objetivos de Aprendizado

Este projeto demonstra:
- ✅ **Localização GPS**: Obtenção de latitude e longitude
- ✅ **Permissões Android**: Solicitação e verificação
- ✅ **LocationManager**: Uso do serviço de localização
- ✅ **LocationListener**: Recebimento de atualizações
- ✅ **Providers de Localização**: GPS e Network
- ✅ **Verificação de Rede**: Identificação de tipo de conexão
- ✅ **Interface de Usuário**: Exibição de dados de localização
- ✅ **Configurações do Dispositivo**: Integração com settings

## 🌟 Vantagens do Sistema

### **Dual Provider:**
- **Network Provider**: Rápido, funciona em ambientes fechados
- **GPS Provider**: Preciso, funciona em ambientes abertos

### **Configurações Flexíveis:**
- **Tempo de atualização** configurável
- **Distância mínima** para atualização
- **Fallback automático** entre providers

### **Interface Intuitiva:**
- **Cores diferenciadas** para cada informação
- **Layout organizado** e fácil de ler
- **Botão para mapa** integrado

---

**Desenvolvido com ❤️ para o Curso de Desenvolvimento Android Java e Kotlin**  
**Professor Marco Maddo** 🎓 