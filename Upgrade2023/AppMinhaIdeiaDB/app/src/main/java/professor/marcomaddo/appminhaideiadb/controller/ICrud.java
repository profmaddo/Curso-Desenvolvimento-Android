package professor.marcomaddo.appminhaideiadb.controller;

import java.util.List;

public interface ICrud<T> {

    // Métodos para persistência de dados no Banco de Dados

    // Incluir
    public boolean incluir(T obj);

    // Alterar
    public boolean alterar(T obj);

    // Deletar
    public boolean deletar(int id);

    // Listar
    public List<T> listar();

    // CRUD - Create Retrieve Update Delete

}
