# 📱 FontesAulaAppSendSMS - Aplicativo de Envio de SMS

> **Parte do Curso Desenvolvimento Android Java e Kotlin**  
> **Professor: Marco Maddo** 🎓

## 📋 Sobre o Projeto

O **FontesAulaAppSendSMS** é um aplicativo Android que demonstra como implementar funcionalidades de **envio de SMS** programaticamente. O projeto serve como exemplo prático de como trabalhar com recursos de telefonia no Android, incluindo:

- **Envio de SMS** via código Java
- **Solicitação de permissões** de telefonia
- **Interface para composição** de mensagens
- **Validação de entrada** de dados
- **Integração com serviços** de SMS do Android

## ⚠️ **IMPORTANTE: Considerações de Segurança e Limitações**

### 🚨 **Limitações Críticas**

#### **1. Restrições do Android 6.0+ (API 23+)**
- **Permissões perigosas** requerem aprovação manual do usuário
- **SEND_SMS** é considerada permissão perigosa
- **Aplicativos podem ser rejeitados** na Google Play Store

#### **2. Restrições do Android 10+ (API 29+)**
- **Apps não podem enviar SMS** em background
- **Restrições de acesso** a recursos de telefonia
- **Políticas mais rigorosas** de segurança

#### **3. Restrições do Android 11+ (API 30+)**
- **Permissões de telefonia** ainda mais restritas
- **Apps precisam ser** "Default SMS App" para algumas funcionalidades
- **Políticas de privacidade** mais rigorosas

### 🔒 **Aspectos de Segurança**

#### **Riscos de Segurança:**
- **Spam SMS**: Possibilidade de envio em massa
- **Custos**: SMS podem gerar cobranças
- **Privacidade**: Acesso a informações de telefonia
- **Malware**: Potencial para uso malicioso

#### **Boas Práticas de Segurança:**
- ✅ **Validação de entrada**: Verificar número e mensagem
- ✅ **Limitação de envio**: Evitar spam
- ✅ **Feedback ao usuário**: Confirmar antes de enviar
- ✅ **Tratamento de erros**: Lidar com falhas graciosamente

## 🎯 Funcionalidades do App

O aplicativo oferece as seguintes funcionalidades:

1. **📝 Composição de SMS**: Interface para digitar mensagem
2. **📞 Inserção de Número**: Campo para número de destino
3. **📤 Envio de SMS**: Funcionalidade de envio programático
4. **✅ Validação**: Verificação de dados de entrada
5. **🔐 Gerenciamento de Permissões**: Solicitação de permissões necessárias

## 🏗️ Arquitetura do Projeto

### 📁 **Estrutura de Arquivos**

```
app/src/main/
├── java/foo/maddo/fontes_aulaappsendsms/
│   └── MainActivity.java        # Activity principal
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

A **Activity Principal** que gerencia a interface e funcionalidades de SMS.

```java
public class MainActivity extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);
        // Configuração da interface e funcionalidades SMS
    }
}
```

**Funcionalidades Implementadas:**
- ✅ **Interface de usuário**: Campos para número e mensagem
- ✅ **Validação de dados**: Verificação de entrada
- ✅ **Envio de SMS**: Integração com SmsManager
- ✅ **Tratamento de erros**: Feedback ao usuário

## 🔐 Permissões Necessárias

### 📄 **AndroidManifest.xml**

O aplicativo requer as seguintes permissões:

```xml
<!-- Permissões requeridas para envio de SMS -->
<uses-feature
    android:name="android.hardware.telephony"
    android:required="false" />

<uses-permission android:name="android.permission.SEND_SMS"/>
<uses-permission android:name="android.permission.READ_PHONE_STATE"/>
```

### 📋 **Explicação das Permissões:**

| Permissão | Função | Risco | Quando Usada |
|-----------|--------|-------|--------------|
| **SEND_SMS** | Enviar mensagens SMS | Alto | Envio de SMS |
| **READ_PHONE_STATE** | Ler estado do telefone | Médio | Verificação de rede |
| **android.hardware.telephony** | Recursos de telefonia | Baixo | Verificação de hardware |

### ⚠️ **Permissões Perigosas**

#### **SEND_SMS (Permissão Perigosa)**
- **Requer aprovação manual** do usuário
- **Pode ser revogada** a qualquer momento
- **Considerada perigosa** pelo Android
- **Pode causar rejeição** na Google Play Store

#### **READ_PHONE_STATE (Permissão Perigosa)**
- **Acesso a informações** do dispositivo
- **Requer justificativa** clara para uso
- **Pode ser restrita** em versões futuras

## 🎨 Interface de Usuário

### 📄 **activity_main.xml**

Layout que permite composição e envio de SMS:

#### **Componentes:**

| Componente | ID | Tipo | Função |
|------------|----|------|--------|
| **Título** | - | `TextView` | "ENVIAR SMS" |
| **Campo Número** | `editSMSPara` | `EditText` | Número de destino |
| **Campo Mensagem** | `editSMSMensagem` | `EditText` | Texto da mensagem |
| **Botão Enviar** | `btnEnviar` | `Button` | Enviar SMS |

#### **Características dos Campos:**

```xml
<!-- Campo para número de telefone -->
<EditText
    android:id="@+id/editSMSPara"
    android:inputType="phone"
    android:hint="Para:" />

<!-- Campo para mensagem -->
<EditText
    android:id="@+id/editSMSMensagem"
    android:inputType="textMultiLine"
    android:lines="5"
    android:hint="Mensagem:" />
```

**Características:**
- **`inputType="phone"`**: Teclado numérico para número
- **`inputType="textMultiLine"`**: Suporte a múltiplas linhas
- **`lines="5"`**: Altura de 5 linhas para mensagem
- **`hint`**: Texto de dica quando campo está vazio

## 📱 Implementação de SMS

### 🔧 **Código para Envio de SMS**

```java
// Verificação de permissões
if (ContextCompat.checkSelfPermission(this, Manifest.permission.SEND_SMS) 
    != PackageManager.PERMISSION_GRANTED) {
    // Solicitar permissão
    ActivityCompat.requestPermissions(this, 
        new String[]{Manifest.permission.SEND_SMS}, 
        SMS_PERMISSION_REQUEST);
} else {
    // Enviar SMS
    sendSMS();
}

// Método para enviar SMS
private void sendSMS() {
    String phoneNumber = editSMSPara.getText().toString();
    String message = editSMSMensagem.getText().toString();
    
    try {
        SmsManager smsManager = SmsManager.getDefault();
        smsManager.sendTextMessage(phoneNumber, null, message, null, null);
        Toast.makeText(this, "SMS enviado com sucesso!", Toast.LENGTH_SHORT).show();
    } catch (Exception e) {
        Toast.makeText(this, "Erro ao enviar SMS: " + e.getMessage(), 
            Toast.LENGTH_LONG).show();
    }
}
```

### 📊 **Validação de Dados**

```java
// Validação do número de telefone
private boolean isValidPhoneNumber(String phoneNumber) {
    return phoneNumber != null && 
           phoneNumber.length() >= 10 && 
           phoneNumber.matches("\\d+");
}

// Validação da mensagem
private boolean isValidMessage(String message) {
    return message != null && 
           !message.trim().isEmpty() && 
           message.length() <= 160; // Limite SMS
}
```

## 🔄 Fluxo de Execução

### 📱 **Inicialização do App:**

1. **MainActivity.onCreate()** é executado
2. **Layout XML** é carregado
3. **Interface** é configurada
4. **Permissões** são verificadas

### 📤 **Processo de Envio de SMS:**

1. **Validação de Permissões**
   - Verificar se `SEND_SMS` foi concedida
   - Solicitar permissão se necessário

2. **Validação de Dados**
   - Verificar número de telefone
   - Verificar conteúdo da mensagem
   - Validar tamanho da mensagem

3. **Envio do SMS**
   - Obter instância do `SmsManager`
   - Enviar mensagem via `sendTextMessage()`
   - Tratar sucesso/erro

4. **Feedback ao Usuário**
   - Mostrar confirmação de envio
   - Exibir erros se houver

## 🛠️ Tecnologias e Recursos Utilizados

### **Linguagem e Framework:**
- **Java**: Linguagem de programação principal
- **Android SDK**: Framework de desenvolvimento
- **SmsManager**: Gerenciamento de SMS
- **ActivityCompat**: Gerenciamento de permissões

### **Componentes de SMS:**
- **SmsManager.getDefault()**: Gerenciador padrão de SMS
- **sendTextMessage()**: Método para envio de SMS
- **SMS_PERMISSION_REQUEST**: Código para solicitação de permissão

### **Recursos de Interface:**
- **LinearLayout**: Layout vertical
- **EditText**: Campos de entrada
- **Button**: Ação de envio
- **Validação de entrada**: Verificação de dados

## 🚀 Como Executar

### **1. Configuração do Dispositivo:**
1. **Dispositivo físico** com chip SIM
2. **Créditos de SMS** disponíveis
3. **Android 6.0+** para permissões dinâmicas

### **2. Configuração do App:**
1. **Clone** o repositório
2. **Abra** o projeto no Android Studio
3. **Sincronize** o Gradle
4. **Execute** em dispositivo físico

### **3. Permissões:**
1. **Conceda permissão SEND_SMS** quando solicitado
2. **Conceda permissão READ_PHONE_STATE** se necessário
3. **Confirme** as permissões perigosas

## 📊 Saída Esperada

### **Interface do App:**
- **Título**: "ENVIAR SMS"
- **Campo "Para"**: Número de telefone
- **Campo "Mensagem"**: Texto da mensagem
- **Botão "Enviar"**: Ação de envio

### **Comportamento:**
- **Validação**: Verificação de número e mensagem
- **Envio**: SMS enviado para o número especificado
- **Feedback**: Confirmação de envio ou erro
- **Custo**: Pode gerar cobrança de SMS

## 🎯 Objetivos de Aprendizado

Este projeto demonstra:
- ✅ **Envio de SMS**: Programação de envio de mensagens
- ✅ **Permissões Perigosas**: Solicitação e verificação
- ✅ **SmsManager**: Uso do serviço de SMS
- ✅ **Validação de Dados**: Verificação de entrada
- ✅ **Tratamento de Erros**: Lidar com falhas
- ✅ **Interface de Usuário**: Composição de SMS
- ✅ **Segurança**: Considerações de privacidade

## ⚠️ Limitações e Considerações

### **Limitações Técnicas:**
- **Android 6.0+**: Permissões dinâmicas obrigatórias
- **Android 10+**: Restrições de background
- **Android 11+**: Políticas mais rigorosas
- **Google Play Store**: Pode rejeitar apps com SMS

### **Limitações de Negócio:**
- **Custos**: SMS podem gerar cobranças
- **Spam**: Risco de uso malicioso
- **Privacidade**: Acesso a dados sensíveis
- **Regulamentações**: Leis de proteção de dados

### **Alternativas Recomendadas:**
- **Push Notifications**: Para notificações
- **Email**: Para comunicações
- **In-App Messaging**: Para mensagens internas
- **WhatsApp Business API**: Para mensagens comerciais

## 🌟 Vantagens e Desvantagens

### **✅ Vantagens:**
- **Alta Taxa de Entrega**: SMS chegam diretamente
- **Imediato**: Entrega instantânea
- **Universal**: Funciona em qualquer dispositivo
- **Confirmação**: Feedback de entrega

### **❌ Desvantagens:**
- **Custo**: Pode gerar cobranças
- **Restrições**: Limitações do Android
- **Segurança**: Riscos de privacidade
- **Spam**: Potencial para uso malicioso

---

**Desenvolvido com ❤️ para o Curso de Desenvolvimento Android Java e Kotlin**  
**Professor Marco Maddo** 🎓 