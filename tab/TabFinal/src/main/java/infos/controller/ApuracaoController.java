package infos.controller;

import infos.repository.*;
import infos.exception.ExecuteException;
import infos.model.*;
import javax.persistence.PersistenceException;
import java.util.List;

public class ApuracaoController {

    private FuncionarioRepository funcionarioRepository;
    private RestauranteRepository restauranteRepository;
    private VotoRepository votoRepository;

    public ApuracaoController() {
        this.funcionarioRepository = new FuncionarioRepository();
        this.restauranteRepository = new RestauranteRepository();
        this.votoRepository = new VotoRepository();
    }

    public void votar(String funcionarioNome, String restauranteNome) throws ExecuteException {
        Funcionario funcionario = funcionarioRepository.buscarPorNome(funcionarioNome);
        Restaurante restaurante = restauranteRepository.buscarPorNome(restauranteNome);
        Calendar data = Calendar.getInstance();

        if (funcionario == null || restaurante == null) {
            throw new ExecuteException("Falha ao inserir funcionario ou restaurante");
        }

        if (votoRepository.busca(funcionario, data).isEmpty()) {
            Voto newVoto = new Voto(data, funcionario, restaurante);
            funcionario.votar(newVoto);
            funcionarioRepository.atualizar(funcionario);
        } else {
            throw new ExecuteException("Funcionário já votou hoje.");
        }
    }



    public void inserirFuncionario(String nome) throws ExecuteException {
        Funcionario funcionario = funcionarioRepository.buscarPorNome(nome);

        try {
            if (funcionario == null) {
                funcionario = new Funcionario(nome);
                funcionarioRepository.inserir(funcionario);
            }
        } catch (PersistenceException e) {
            throw new ExecuteException("Falha ao inserir funcionario");
        }
    }

    public void inserirRestaurante(String nome) throws ExecuteException {
        Restaurante restaurante = restauranteRepository.buscarPorNome(nome);

        try {
            if (restaurante == null) {
                restaurante = new Restaurante(nome);
                restauranteRepository.inserir(restaurante);
            }
        } catch (PersistenceException e) {
            throw new ExecuteException("Falha ao inserir restaurante");
        }
    }

    public List<Funcionario> listarFuncionario() {
        return funcionarioRepository.buscar();
    }

    public List<Restaurante> listarRestaurante() {
        return restauranteRepository.buscar();
    }


    public void apurarVotacao() {
        Calendar data = Calendar.getInstance();
        List<Voto> votos = votoRepository.apuracao(data);

        for(Voto voto : votos) {
            System.out.println("|" + voto.getFuncionario().getNome() + "|");
            System.out.println("|" + voto.getRestaurante().getNome() + "|");
        }
    }

}

