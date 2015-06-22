package br.com.petGoHome.Fachada;

import java.awt.image.BufferedImage;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.text.Normalizer;
import java.util.Date;
import java.util.List;
import java.util.Properties;
import java.util.Random;
import java.util.UUID;

import javax.imageio.ImageIO;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import org.apache.commons.fileupload.FileItemStream;
import org.apache.commons.mail.Email;
import org.apache.commons.mail.EmailException;
import org.apache.commons.mail.SimpleEmail;
import org.javahelp4u.mailSender.MailSender;

import br.com.petGoHome.DAO.AdministradorDao;
import br.com.petGoHome.DAO.BannerDAO;
import br.com.petGoHome.DAO.CachorroDao;
import br.com.petGoHome.DAO.GatoDao;
import br.com.petGoHome.DAO.HashUtil;
import br.com.petGoHome.DAO.HistoricoBannerDao;
import br.com.petGoHome.DAO.HistoricoFotosPetDao;
import br.com.petGoHome.DAO.PessoaDao;
import br.com.petGoHome.DAO.PessoaFisicaDao;
import br.com.petGoHome.DAO.PetDao;
import br.com.petGoHome.DAO.PetShopDao;
import br.com.petGoHome.DAO.RacaCachoroDao;
import br.com.petGoHome.DAO.RacaGatoDao;
import br.com.petGoHome.DAO.TagDao;
import br.com.petGoHome.banner.Banner;
import br.com.petGoHome.banner.HistoricoBanner;
import br.com.petGoHome.entidades.Administrador;
import br.com.petGoHome.entidades.Cachorro;
import br.com.petGoHome.entidades.Gato;
import br.com.petGoHome.entidades.HistoricoFotosPet;
import br.com.petGoHome.entidades.Pessoa;
import br.com.petGoHome.entidades.PessoaFisica;
import br.com.petGoHome.entidades.Pet;
import br.com.petGoHome.entidades.PetShop;
import br.com.petGoHome.entidades.RacaCachorro;
import br.com.petGoHome.entidades.RacaGato;
import br.com.petGoHome.entidades.Tag;

public class Fachada {

	static EntityManagerFactory factory = Persistence
			.createEntityManagerFactory("petgohome");

	/*------------------------------------------------------------------------------------*/
	/* ---------------------------------[PESSOA] */
	/*------------------------------------------------------------------------------------*/

	public static String criptografarSenhaMd5(String senha) {

		String senhacriptografada = "";

		if (!senha.equals("") && senha != null) {

			System.out.println("Senha recebida: " + senha);

			senhacriptografada = HashUtil.stringToMD5(senha);
			System.out.println("Senha criptografada: " + senhacriptografada);

			return senhacriptografada;
		} else {

			return null;
		}
	}

	public static Pessoa logarPessoa(String login, String senha) {
		// val 123

		String senhaCriptografada = "";

		senhaCriptografada = HashUtil.stringToMD5(senha);
		System.out.println(senhaCriptografada);
		EntityManager manager = factory.createEntityManager();
		PessoaDao usuarioDao = new PessoaDao(manager);
		List<Pessoa> usuarios = usuarioDao.logarPessoa(login,
				senhaCriptografada);

		if (usuarios.isEmpty() || login == "") {
			System.out.println("Login incorreto");
		} else {
			return usuarios.get(0);
		}
		return null;
	}
	
	public static List<Pessoa> listarLoginsExistentes(String login) {
		EntityManager manager = factory.createEntityManager();
		PessoaDao usDao = new PessoaDao(manager);
		return usDao.buscarLogin(login);
	}

	public static List<Pessoa> listarTodasPessoas() {
		EntityManager manager = factory.createEntityManager();
		PessoaDao usDao = new PessoaDao(manager);
		return usDao.listarTodos();
	}

	// Pega o numero de paginas
	public static int getQtdePag() {
		EntityManager manager = factory.createEntityManager();
		PessoaDao projetoDao = new PessoaDao(manager);
		return projetoDao.getQuantidade();
	}

	// Pega o numero de Pets
	// ATENçÂO = O metodo tem que ter o DAO do tipo

	public static int getQtdePagDePets() {
		EntityManager manager = factory.createEntityManager();
		// específico. No caso aqui o PET.
		PetDao projetoDao = new PetDao(manager);
		return projetoDao.getQuantidade();
	}

	public static List<Pessoa> listarTodasPessoasLimitadas(int pag) {
		EntityManager manager = factory.createEntityManager();
		PessoaDao usDao = new PessoaDao(manager);
		return usDao.listarTodosLimitado(pag);
	}

	public static void salvarPessoa(Pessoa pessoa) {
		EntityManager manager = factory.createEntityManager();
		PessoaDao pessoaDao = new PessoaDao(manager);
		System.out.println("Senha sem hash: " + pessoa.getSenha());
		pessoa.setSenha(HashUtil.stringToMD5(pessoa.getSenha()));
		System.out.println("Senha com hash: " + pessoa.getSenha());
		manager.getTransaction().begin();
		if (pessoa instanceof Administrador) {
			System.out.println("Salvou o Tipo em ADM.");
			pessoaDao.salvar((Administrador) pessoa);
		} else if (pessoa instanceof PessoaFisica) {
			System.out.println("Salvou o Tipo em PessoaFisica.");
			pessoaDao.salvar((PessoaFisica) pessoa);
		}
		manager.getTransaction().commit();
		manager.close();
	}

	public static void alterarPessoa(Pessoa pessoa) {
		EntityManager manager = factory.createEntityManager();
		PessoaDao pessoaDao = new PessoaDao(manager);
		manager.getTransaction().begin();
		if (pessoa instanceof Administrador) {
			System.out.println("alterar o Tipo em ADM.");
			pessoaDao.alterar((Administrador) pessoa);
		} else if (pessoa instanceof PessoaFisica) {
			System.out.println("alterar o Tipo em PessoaFisica.");
			pessoaDao.alterar((PessoaFisica) pessoa);
		}
		manager.getTransaction().commit();
		manager.close();
	}

	public static void verificarSenha(Pessoa pessoa) {
		pessoa.setSenha(HashUtil.stringToMD5(pessoa.getSenha()));
		return;
	}

	public static void excluirPessoa(long id) {
		EntityManager manager = factory.createEntityManager();
		PessoaDao uDao = new PessoaDao(manager);
		Pessoa usuario = uDao.buscarPorId(id);

		manager.getTransaction().begin();
		uDao.remover(usuario);
		manager.getTransaction().commit();
		manager.close();

	}

	public static Pessoa buscarPessoaPorId(long id) {
		EntityManager manager = factory.createEntityManager();
		PessoaDao pessoaDao = new PessoaDao(manager);
		return pessoaDao.buscarPorId(id);
	}

	public static Pessoa buscarAdministradorPorId(long id) {
		EntityManager manager = factory.createEntityManager();
		AdministradorDao pessoaDao = new AdministradorDao(manager);
		return pessoaDao.buscarPorId(id);
	}

	public static List<PessoaFisica> buscarPessoafisicaPeloSeuCPFeoEmail(
			String cpf, String email) {
		EntityManager manager = factory.createEntityManager();
		PessoaFisicaDao pessoaDao = new PessoaFisicaDao(manager);
		return pessoaDao.buscarPessoaFisicaPorCpfeEmail(cpf, email);
	}

	public static List<Pessoa> buscarPessoaPorNome(String nome) {
		EntityManager manager = factory.createEntityManager();
		PessoaDao pessoaDao = new PessoaDao(manager);
		return pessoaDao.buscarPorNome(nome);
	}

	/*------------------------------------------------------------------------------------
	-----------------------------------[CACHORRO]
	/*------------------------------------------------------------------------------------*/

	public static void salvarPet(Pet pet) {

		EntityManager manager = factory.createEntityManager();
		PetDao pDao = new PetDao(manager);

		manager.getTransaction().begin();
		if (pet instanceof Cachorro) {
			System.out.println("Salvou o Tipo em Cachorro.");
			pDao.salvar((Cachorro) pet);
		} else if (pet instanceof Gato) {
			System.out.println("Salvou o Tipo em Gato.");
			pDao.salvar((Gato) pet);
		}
		manager.getTransaction().commit();
		manager.close();
	}

	public static List<Pet> listarTodosPetsPorDono(Pessoa pessoa) {
		EntityManager manager = factory.createEntityManager();
		PetDao pDao = new PetDao(manager);
		return pDao.listarTodosPetsporDono(pessoa);
	}

	public static List<Cachorro> listarTodosCachorrosPorDono(Pessoa pessoa) {
		EntityManager manager = factory.createEntityManager();
		CachorroDao pDao = new CachorroDao(manager);
		return pDao.listarTodosCachorrosPorDono(pessoa);
	}

	public static List<Gato> listarTodosGatosPorDono(Pessoa pessoa) {
		EntityManager manager = factory.createEntityManager();
		GatoDao pDao = new GatoDao(manager);
		return pDao.listarTodosGatosPorDono(pessoa);
	}

	public static List<Pet> listarTodosPets() {
		EntityManager manager = factory.createEntityManager();
		PetDao pDao = new PetDao(manager);
		return pDao.listarTodos();
	}

	public static List<Pet> listarTodosPetsLimitado(int pag) {
		EntityManager manager = factory.createEntityManager();
		PetDao pDao = new PetDao(manager);
		return pDao.listarTodosLimitado(pag);
	}

	public static void alterarPet(Pet pet) {
		EntityManager manager = factory.createEntityManager();
		PetDao petDao = new PetDao(manager);

		manager.getTransaction().begin();
		if (pet instanceof Cachorro) {
			System.out.println("Alterou o Tipo em Cachorro.");
			petDao.alterar((Cachorro) pet);
		} else if (pet instanceof Gato) {
			System.out.println("Alterou o Tipo em Gato.");
			petDao.alterar((Gato) pet);
		}
		manager.getTransaction().commit();
		manager.close();
	}

	public static void excluirPet(long id) {
		EntityManager manager = factory.createEntityManager();
		PetDao pDao = new PetDao(manager);
		Pet pet = pDao.buscarPorId(id);

		manager.getTransaction().begin();
		pDao.remover(pet);
		manager.getTransaction().commit();
		manager.close();

	}

	public static Pet buscarPetPorId(long id) {
		EntityManager manager = factory.createEntityManager();
		PetDao caoDao = new PetDao(manager);
		return caoDao.buscarPorId(id);
	}

	public static List<Pet> buscarPetPorNome(String nome) {
		EntityManager manager = factory.createEntityManager();
		PetDao caoDao = new PetDao(manager);
		return caoDao.buscarPorNome(nome);
	}

	public static Cachorro buscarCachorroPorId(long id) {
		EntityManager manager = factory.createEntityManager();
		CachorroDao caoDao = new CachorroDao(manager);
		return caoDao.buscarPorId(id);
	}

	public static List<Cachorro> buscarCachorroPorNome(String nome) {
		EntityManager manager = factory.createEntityManager();
		CachorroDao caoDao = new CachorroDao(manager);
		return caoDao.buscarPorNome(nome);
	}

	public static Gato buscarGatoPorId(long id) {
		EntityManager manager = factory.createEntityManager();
		GatoDao caoDao = new GatoDao(manager);
		return caoDao.buscarPorId(id);
	}

	public static List<Gato> buscaGatoPorNome(String nome) {
		EntityManager manager = factory.createEntityManager();
		GatoDao caoDao = new GatoDao(manager);
		return caoDao.buscarPorNome(nome);
	}

	public static List<HistoricoFotosPet> buscarHistoricoPetCompletoPorId(
			long idPet) {
		EntityManager manager = factory.createEntityManager();
		HistoricoFotosPetDao caoDao = new HistoricoFotosPetDao(manager);
		return caoDao.buscarTodoHistoricoPorPet(idPet);
	}

	public static void salvarHistoricoPet(HistoricoFotosPet rc) {

		EntityManager manager = factory.createEntityManager();
		HistoricoFotosPetDao rcDao = new HistoricoFotosPetDao(manager);
		manager.getTransaction().begin();
		rcDao.salvar(rc);
		manager.getTransaction().commit();
		manager.close();

	}

	/*------------------------------------------------------------------------------------
	  --------------------------------[Raca CACHORRO] --------------------------------- --
	  ------------------------------------------------------------------------------------*/

	public static void salvarRacaCachorro(RacaCachorro rc) {

		EntityManager manager = factory.createEntityManager();
		RacaCachoroDao rcDao = new RacaCachoroDao(manager);
		manager.getTransaction().begin();
		rcDao.salvar(rc);
		manager.getTransaction().commit();
		manager.close();

	}

	public static List<RacaCachorro> listarTodasRacasCachorro() {
		EntityManager manager = factory.createEntityManager();
		RacaCachoroDao rcDao = new RacaCachoroDao(manager);
		return rcDao.listarTodos();
	}

	public static void alterarRacaCachorro(RacaCachorro rc) {

		EntityManager manager = factory.createEntityManager();
		RacaCachoroDao rcDao = new RacaCachoroDao(manager);

		manager.getTransaction().begin();
		rcDao.alterar(rc);
		manager.getTransaction().commit();
		manager.close();
	}

	public static void excluirRacaCachorro(long id) {
		EntityManager manager = factory.createEntityManager();
		RacaCachoroDao cDao = new RacaCachoroDao(manager);
		RacaCachorro rc = cDao.buscarPorId(id);

		manager.getTransaction().begin();
		cDao.remover(rc);
		manager.getTransaction().commit();
		manager.close();

	}

	public static RacaCachorro buscarRacaCachorroPorId(long id) {
		EntityManager manager = factory.createEntityManager();
		RacaCachoroDao rDao = new RacaCachoroDao(manager);
		return rDao.buscarPorId(id);
	}

	public static List<RacaCachorro> buscarRacaCachorroPorNome(String nome) {
		EntityManager manager = factory.createEntityManager();
		RacaCachoroDao racaCachorroDao = new RacaCachoroDao(manager);
		return racaCachorroDao.buscarPorNome(nome);
	}

	/*------------------------------------------------------------------------------------
	  --------------------------------[Pessoa Fisica] --------------------------------- --
	  ------------------------------------------------------------------------------------*/

	public static List<PessoaFisica> listarTodasPessoaFisicas() {
		EntityManager manager = factory.createEntityManager();
		PessoaFisicaDao pDao = new PessoaFisicaDao(manager);

		return pDao.listarTodos();
	}

	public static void excluirPessoaFisica(Long id) {
		EntityManager manager = factory.createEntityManager();
		PessoaFisicaDao pfDao = new PessoaFisicaDao(manager);
		PessoaFisica pf = pfDao.buscarPorId(id);

		manager.getTransaction().begin();
		pfDao.remover(pf);
		manager.getTransaction().commit();
		manager.close();

	}

	public static PessoaFisica buscarPessoaFisicaPorId(Long id) {
		EntityManager manager = factory.createEntityManager();
		PessoaFisicaDao pfDao = new PessoaFisicaDao(manager);
		return pfDao.buscarPorId(id);
	}

	public static Administrador buscarPessoaADMPorId(Long id) {
		EntityManager manager = factory.createEntityManager();
		AdministradorDao pfDao = new AdministradorDao(manager);
		return pfDao.buscarPorId(id);
	}

	public static List<PessoaFisica> buscarPessoaFisicaPorNome(String nome) {
		EntityManager manager = factory.createEntityManager();
		PessoaFisicaDao pfDao = new PessoaFisicaDao(manager);
		return pfDao.buscarPorNome(nome);
	}

	/*------------------------------------------------------------------------------------
	  --------------------------------[Raca GATO] --------------------------------- --
	  ------------------------------------------------------------------------------------*/

	public static void salvarRacaGato(RacaGato rc) {

		EntityManager manager = factory.createEntityManager();
		RacaGatoDao rcDao = new RacaGatoDao(manager);
		manager.getTransaction().begin();
		rcDao.salvar(rc);
		manager.getTransaction().commit();
		manager.close();

	}

	public static List<RacaGato> listarTodasRacaGato() {
		EntityManager manager = factory.createEntityManager();
		RacaGatoDao rcDao = new RacaGatoDao(manager);
		return rcDao.listarTodos();
	}

	public static void alterarRacaGato(RacaGato rc) {

		EntityManager manager = factory.createEntityManager();
		RacaGatoDao rcDao = new RacaGatoDao(manager);

		manager.getTransaction().begin();
		rcDao.alterar(rc);
		manager.getTransaction().commit();
		manager.close();
	}

	public static void excluirRacaGato(long id) {
		EntityManager manager = factory.createEntityManager();
		RacaGatoDao cDao = new RacaGatoDao(manager);
		RacaGato rc = cDao.buscarPorId(id);

		manager.getTransaction().begin();
		cDao.remover(rc);
		manager.getTransaction().commit();
		manager.close();

	}

	public static RacaGato buscarRacaGatoPorId(long id) {
		EntityManager manager = factory.createEntityManager();
		RacaGatoDao rDao = new RacaGatoDao(manager);
		return rDao.buscarPorId(id);
	}

	public static List<RacaGato> buscarRacaGatoPorNome(String nome) {
		EntityManager manager = factory.createEntityManager();
		RacaGatoDao racaGatoDao = new RacaGatoDao(manager);
		return racaGatoDao.buscarPorNome(nome);
	}

	public static List<PessoaFisica> buscarPessoaFisicaPorCPFeNome(String nome,
			String cpf) {
		EntityManager manager = factory.createEntityManager();
		PessoaFisicaDao pDao = new PessoaFisicaDao(manager);
		return pDao.buscarPessoaFisicaPorCPF(nome, cpf);
	}

	public static List<PessoaFisica> buscarPessoaFisicaPorCPF(String cpf) {
		EntityManager manager = factory.createEntityManager();
		PessoaFisicaDao pDao = new PessoaFisicaDao(manager);
		return pDao.buscarPFPorCPF(cpf);
	}

	/*------------------------------------------------------------------------------------
	-----------------------------------[PETSHOP]
	/*------------------------------------------------------------------------------------*/

	public static void salvarPetShop(PetShop rc) {

		EntityManager manager = factory.createEntityManager();
		PetShopDao rcDao = new PetShopDao(manager);
		manager.getTransaction().begin();
		rcDao.salvar(rc);
		manager.getTransaction().commit();
		manager.close();
	}

	public static List<PetShop> listarTodosPetShops() {
		EntityManager manager = factory.createEntityManager();
		PetShopDao rcDao = new PetShopDao(manager);
		return rcDao.listarTodos();
	}

	public static void alterarPetShop(PetShop rc) {

		EntityManager manager = factory.createEntityManager();
		PetShopDao rcDao = new PetShopDao(manager);

		manager.getTransaction().begin();
		rcDao.alterar(rc);
		manager.getTransaction().commit();
		manager.close();
	}

	public static void excluirPetShop(Long id) {
		EntityManager manager = factory.createEntityManager();
		PetShopDao pfDao = new PetShopDao(manager);
		PetShop pf = pfDao.buscarPorId(id);

		manager.getTransaction().begin();
		pfDao.remover(pf);
		manager.getTransaction().commit();
		manager.close();
	}

	public static PetShop buscarPetShopPorId(long id) {
		EntityManager manager = factory.createEntityManager();
		PetShopDao rDao = new PetShopDao(manager);
		return rDao.buscarPorId(id);
	}

	public static List<PetShop> buscarPetShopPorNome(String nome) {
		EntityManager manager = factory.createEntityManager();
		PetShopDao petShopDao = new PetShopDao(manager);
		return petShopDao.buscarPorNome(nome);
	}

	public static List<PetShop> buscarPetShopNomeECNPJ(String nome, String cnpj) {
		EntityManager manager = factory.createEntityManager();
		PetShopDao pDao = new PetShopDao(manager);
		return pDao.buscarPetShopPorCNPJ(nome, cnpj);
	}

	public static List<PetShop> listarTodosPetShopLimitados(int pag) {
		EntityManager manager = factory.createEntityManager();
		PetShopDao usDao = new PetShopDao(manager);
		return usDao.listarTodosLimitado(pag);
	}

	public static int getQtdePagPetShop() {
		EntityManager manager = factory.createEntityManager();
		PetShopDao projetoDao = new PetShopDao(manager);
		return projetoDao.getQuantidade();
	}

	/*------------------------------------------------------------------------------------
	---------------------------------------[TAG]
	/*------------------------------------------------------------------------------------*/

	public static void salvarTAG(Tag rc) {

		EntityManager manager = factory.createEntityManager();
		TagDao rcDao = new TagDao(manager);
		manager.getTransaction().begin();
		rcDao.salvar(rc);
		manager.getTransaction().commit();
		manager.close();
	}

	public static List<Tag> listarTodasTAGS() {
		EntityManager manager = factory.createEntityManager();
		TagDao rcDao = new TagDao(manager);
		return rcDao.listarTodos();
	}

	public static Tag buscarTAGPorId(long id) {
		EntityManager manager = factory.createEntityManager();
		TagDao rDao = new TagDao(manager);
		return rDao.buscarPorId(id);
	}

	public static List<Tag> buscarTagPorNome(String valorTag) {
		EntityManager manager = factory.createEntityManager();
		TagDao petShopDao = new TagDao(manager);
		return petShopDao.buscarTagPorNome(valorTag);
	}

	public static List<Tag> buscarTagPorNomeDaTag(String valorTag) {
		EntityManager manager = factory.createEntityManager();
		TagDao petShopDao = new TagDao(manager);
		return petShopDao.buscarTagPorNome(valorTag);
	}

	public static List<Pet> buscarPetPorTAG(String valorTag) {
		EntityManager manager = factory.createEntityManager();
		PetDao petShopDao = new PetDao(manager);
		return petShopDao.buscarPetPorTag(valorTag);

	}

	public static List<Tag> buscarTAGPeloIdDoPet(Long idPet) {
		EntityManager manager = factory.createEntityManager();
		PetDao petShopDao = new PetDao(manager);
		return petShopDao.buscarTagPorPet(idPet);

	}

	public static void alterarTAG(Tag rc) {

		EntityManager manager = factory.createEntityManager();
		TagDao rcDao = new TagDao(manager);

		manager.getTransaction().begin();
		rcDao.alterar(rc);
		manager.getTransaction().commit();
		manager.close();
	}
	
	public static List<Tag> listarTodasTagsLimitado(int pag) {
		EntityManager manager = factory.createEntityManager();
		TagDao pDao = new TagDao(manager);
		return pDao.listarTodosLimitado(pag);
	}
	public static int getQtdePagTags() {
		EntityManager manager = factory.createEntityManager();
		TagDao pDao = new TagDao(manager);
		return pDao.getQuantidade();
	}
	
	public static List<Tag> buscarTagPorStatusUsado(){
		EntityManager manager = factory.createEntityManager();
		TagDao pd = new TagDao(manager);
		return pd.buscarTagPorStatusUsado();
	}
	public static List<Tag> buscarTagPorStatusLivre(){
		EntityManager manager = factory.createEntityManager();
		TagDao pd = new TagDao(manager);
		return pd.buscarTagPorStatusLivre();
	}
	

	/*------------------------------------------------------------------------------------
	-----------------------------------[IMAGEM - FOTO PET]
	/*------------------------------------------------------------------------------------*/

	// public void testSaveBook() {
	//
	// // File file = new File("images\\extjsfirstlook.jpg"); //windows
	// File file = new File("images/extjsfirstlook.jpg");
	// byte[] bFile = new byte[(int) file.length()];
	//
	// try {
	// FileInputStream fileInputStream = new FileInputStream(file);
	// fileInputStream.read(bFile);
	// fileInputStream.close();
	// } catch (Exception e) {
	// e.printStackTrace();
	// }
	//
	// Book book = new Book();
	// book.setName("Ext JS 4 First Look");
	// book.setImage(bFile);
	//
	// bookDAO.saveBook(book);
	//
	// assertNotNull(book.getId());
	// }

	// public static boolean processandoArquivo(String path, FileItemStream
	// item){
	//
	// try {
	// File f = new File(path+File.separator+"images");
	// //verificando se o diretório existe, se não, cria
	// if (!f.exists()){
	// f.mkdir();
	// }
	// File savedfile = new
	// File(f.getAbsolutePath()+File.separator+item.getName());
	// FileOutputStream fos = new FileOutputStream(savedfile);
	// InputStream is = item.openStream();
	// int x = 0;
	// byte[] b = new byte[1024];
	//
	// while ((x= is.read(b))!= -1) {
	// fos.write(b , 0 , x);
	// }
	// fos.flush();
	// fos.close();
	// return true;
	//
	// } catch (Exception e) {
	// System.out.println(e.getMessage());
	// }
	//
	//
	// return false;
	//
	// }

	public static String caracteresEspeciais(String str) {

		/** Troca os caracteres especiais da string por "" **/
		String[] caracteresEspeciais = { ",", "-", ":", "\\(", "\\)", "ª",
				"\\|", "\\\\", "°" };

		for (int i = 0; i < caracteresEspeciais.length; i++) {
			str = str.replaceAll(caracteresEspeciais[i], "");
		}

		/** Troca os espaços no início por "" **/
		str = str.replaceAll("^\\s+", "");
		/** Troca os espaços no início por "" **/
		str = str.replaceAll("\\s+$", "");
		/** Troca os espaços duplicados, tabulações e etc por " " **/
		str = str.replaceAll("\\s+", "-");
		return str;
	}

	public static String removeAcentos(String str) {

		str = Normalizer.normalize(str, Normalizer.Form.NFD);
		str = str.replaceAll("[^\\p{ASCII}]", "");
		return str;

	}

	public static String processandoArquivo(String path, FileItemStream item) {

		String nomeImagem = "";

		if (item != null && !item.getName().equals("")) {

			try {
				// File f = new File(path + File.separator + "images"); // Usa  no PATH do TOMCAT Temp
				//File f = new File(File.separator + "C:/TAGS/images"); // Usa pasta NO path do windows
				File f = new File(File.separator + "home/images"); // Usa pasta NO path do Linux

				/*
				 * SOBRE ALTERAÇÃO DO PATH RELATIVO DA PASTA DE IMAGES -
				 * PRECAUÇÃO PARA QUE A PASTA DE IMAGENS NAO SEJA APAGADA QUANDO
				 * FOR FEITO O DEPLOY DA APLICAÇÃO
				 * 
				 * 1 - Vá na pasta "C:\Program Files\Apache Software
				 * Foundation\Tomcat 7.0\conf\Catalina\localhost" (ou onde voce
				 * instalou o seu tomcat) 2 - Crie um arquivo chamado: seu
				 * contextpath#nomedodiretorioquevocedeseja.xml 3 - Dentro deste
				 * arquivo coloque: <Context docBase="f:/images"></Context> 4 -
				 * Reinicie o tomcat.
				 * 
				 * Entendendo: o nome do arquivo será o "diretorio na url" Por
				 * exemplo, sendo o nome do arquivo
				 * ProjectTomCat#imagens#testando.xml Para acessar o diretorio
				 * será:
				 * localhost:8080/ProjectTomCat/imagens/testando/nome-do-arquivo
				 * -a-ser-acessado-.extesao dentro deste arquivo, voce colocará
				 * o <Context> e no docBase o caminho para esta pasta. no
				 * exemplo, a minha seria f:imagens. Sendo que nesta pasta
				 * contem o arquivo tarlix.jpg. No jsf ficaria:
				 * 
				 * view plaincopy to clipboardprint? <p:graphicImage
				 * value="imagens/tarlix.jpg" />
				 */
				
				
				// verificando se o diretório existe, se não, cria
				if (!f.exists()) {
					f.mkdir();
				}

				// Se o nome do arquivo tiver caracteres especiais o nome da
				// imagem apresentara
				// problemas, pois o html nao carregara, é preciso ajustar isso
				// aqui

				String nomeImagemAdaptado = "";
				String nomeImagemLimpo = "";

				String nomeFoto = item.getName();

				System.out.println("Nome da foto: " + nomeFoto);

				nomeImagemAdaptado = caracteresEspeciais(nomeFoto);
				if(nomeImagemAdaptado.length() > 10){
					nomeImagemLimpo = removeAcentos(nomeImagemAdaptado.substring(1,8)) + ".jpg";
					System.out.println("O nome da Imagem foi maior que 10 caracteres");
				}else{
					nomeImagemLimpo = removeAcentos(nomeImagemAdaptado);
					System.out.println("O nome da Imagem foi MENOR que 10 caracteres");
				}
				

				System.out.println("Nome da foto sem lixo especial: "
						+ nomeImagemLimpo);

				// o guid é um gerador unico global para evitar duplicação de
				// nome
				UUID guid = UUID.randomUUID();
				// File savedfile = new
				// File(f.getAbsolutePath()+File.separator+item.getName());

				// Aqui mistura o nome da foto com GUID mas a STRNG da foto
				// limpa de caracter especial
				File savedfile = new File(f.getAbsolutePath() + File.separator
						+ guid.toString() + nomeImagemLimpo);
				
				String guideNome = guid.toString();

				// Entra qui se por acaso o GUID repetir, coisa muito dificil
				while (savedfile.exists()) {

					// So entrará aqui se ocorre o impossível do GUID repetir

					// -- randonizando uma String perfeita ---//
					String letras = "ABCDEFGHIJKLMNOPQRSTUVYWXZ";

					Random random = new Random();

					String armazenaChaves = "";
					int index = -1;

					for (int i = 0; i < 9; i++) {
						index = random.nextInt(letras.length());
						armazenaChaves += letras.substring(index, index + 1);
					}
					System.out.println(armazenaChaves);

					guid = UUID.randomUUID();
					savedfile = new File(f.getAbsolutePath() + File.separator
							+ guid.toString() + armazenaChaves
							+ nomeImagemLimpo);
					guideNome = guid.toString();
				}

				/*
				 * if (!savedfile.exists()){ savedfile.createNewFile(); }else{
				 * savedfile = new
				 * File(f.getAbsolutePath()+File.separator+guid.toString
				 * ()+item.getName()); }
				 */

				FileOutputStream fos = new FileOutputStream(savedfile);
				InputStream is = item.openStream();
				int x = 0;
				byte[] b = new byte[1024];

				while ((x = is.read(b)) != -1) {
					fos.write(b, 0, x);
				}
				fos.flush();
				fos.close();

				criarMiniatura(savedfile, nomeImagemLimpo, guideNome);
				
				System.out.println("Nome do file: " + savedfile.toString());

				nomeImagem = guid.toString() + nomeImagemLimpo;

				System.out
						.println("Nome apos passar pelo filtro caracteresEspeciaiss: "
								+ nomeImagem);
				return nomeImagem;

			} catch (Exception e) {
				System.out.println(e.getMessage());
			}
		}

		return null;

	}
	
	public static void criarMiniatura(File f, String nome, String guid){
		File fx = new File(File.separator + "home/images/");
		BufferedImage originalImage;
		try {
			originalImage = ImageIO.read(f);
			
			int x=originalImage.getWidth(); 
			int y = originalImage.getHeight();
			
			System.out.println("Largura da imagem: "+x);
			System.out.println("Altura da imagem: "+y);
			
			int width = 0;
			int height = 0;
//			
//			if(x != 0 && y != 0){
//				if(x >= 600 && y <= 300){
//					 width = x/2;
//					 height = y/2;
//				}
//				if(x >= 800 && y >= 600){
//					 width = x/3;
//					 height = y/3;
//				}
//				if(x >= 1024 && y >= 768){
//					 width = x/4;
//					 height = y/3;
//				}
//				if(x >= 1280){
//					 width = x/5;
//					 height = y/3;
//				}
//				if(x >= 2000 && y >= 1500){
//					 width = x/6;
//					 height = y/6;
//				}
//				if(x >= 4000 && y >= 3000){
//					 width = x/11;
//					 height = y/11;
//				}
//				System.out.println("Entrou para redimensionar a foto");
//			}
//			
				width = 240;
				height = 180;
			
			BufferedImage resizedImage = new BufferedImage(width, height, BufferedImage.TYPE_INT_RGB);
			resizedImage.getGraphics().drawImage(originalImage, 0, 0, width, height, null);
			
			ImageIO.write(resizedImage, "jpg", new File(
					fx.getAbsolutePath() + File.separator + "resize_"+guid +nome)); 
			System.out.println("Fez miniatura = " + fx.getAbsolutePath() + File.separator + guid + "resize_" +nome);
		} catch (IOException e) {
			e.printStackTrace();
			System.out.println("Erro em fazer a miniatura da foto.");
		}
	}

	public static boolean enviarEmailEsqueciSenha(Pessoa p) {

		String emailDestino = p.getEmail();
		String senha = p.getSenha();

		String novaSenha = geraSenhaQualquer();

		String senhaCriptografada = "";

		senhaCriptografada = HashUtil.stringToMD5(novaSenha);

		buscarPessoaPorId(p.getId());
		System.out.println("Achou por ID o usuario: " + p.getNome());
		p.setSenha(senhaCriptografada);
		alterarPessoa(p);
		System.out.println("Mergou o usuario com nova senha: " + novaSenha);
		System.out.println("A nova senha embaralhada é: " + senhaCriptografada);

		try {
			// ---------------------------------------FORMA DE ENVIO COM
			// MAIL....
			// Os problemas de envio é relativo as proteções de segurança do
			// GMAL.
			// Lembrar Ativa no gmail a opção de receber email de fonte nao
			// segura.

			Email email = new SimpleEmail();
			email.setDebug(true);
			email.setSmtpPort(578);
			email.setHostName("smtp.gmail.com");
			email.setAuthentication("petgohome@gmail.com", "quartzo102");
			email.setSSLOnConnect(true);
			email.setFrom("petgohome@gmail.com");
			email.setSubject("Recuperação da senha - PetGoHome");
			email.setMsg(desehandoMensagemEmail(novaSenha, p));
			email.addTo(emailDestino);
			email.send();
			System.out.println("Mail sent!");

			// ---------------------------------------FORMA DE ENVIO COM
			// MAIL_SENDER....

			// Properties prop = new Properties();
			// InputStream fis =
			// Thread.currentThread().getContextClassLoader().getResourceAsStream("mail.properties");
			// prop.load(fis);
			//
			// System.out.println("--- Dados do Email --- ");
			// System.out.println(emailDestino);
			//
			// MailSender.sendMail(emailDestino, "Recuperar senha - PETGOHOME",
			// "Tua senha de acesso é: "+senha);

			return true;

		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
		return false;

	}

	public static String desehandoMensagemEmail(String novaSenha, Pessoa p) {

		String mensagem = "[PetGoHome - Security Message] "
				+ "\n"
				+ "\nCaro "
				+ p.getNome()
				+ ", nós geramos uma nova senha para você."
				+ "\nNa próxima vez que fizer o login no site, utilize as seguintes informações:"
				+ "\n" + "\nLogin: " + p.getLogin() + "\nSenha: " + novaSenha
				+ "\n" + "\nO PetGoHome agradeçe o seu contato.";
		return mensagem;

	}

	public static boolean enviarEmailTrocaDeSenha(String novaSenha, Pessoa p) {

		String emailDestino = p.getEmail();

		buscarPessoaPorId(p.getId());
		System.out.println("Achou por ID o usuario: " + p.getNome());
		System.out.println("A nova senha é: " + novaSenha);

		try {
			// ---------------------------------------FORMA DE ENVIO COM
			// MAIL....
			// Os problemas de envio é relativo as proteções de segurança do
			// GMAL.
			// Lembrar Ativa no gmail a opção de receber email de fonte nao
			// segura.

			Email email = new SimpleEmail();
			email.setDebug(true);
			email.setSmtpPort(578);
			email.setHostName("smtp.gmail.com");
			email.setAuthentication("petgohome@gmail.com", "quartzo102");
			email.setSSLOnConnect(true);
			email.setFrom("petgohome@gmail.com");
			email.setSubject("Troca da senha - PetGoHome");
			email.setMsg(emailSenhaAlterada(novaSenha, p));
			email.addTo(emailDestino);
			email.send();
			System.out.println("Envio email de troca senha no Site!");

			return true;

		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
		return false;

	}

	public static boolean enviarEmailGenerico(String nome,
			String emailRemetente, String telefone, String mensagem) {
		try {

			Email email = new SimpleEmail();
			email.setDebug(true);
			email.setSmtpPort(578);
			email.setHostName("smtp.gmail.com");
			email.setAuthentication("petgohome@gmail.com", "quartzo102");
			email.setSSLOnConnect(true);
			email.setFrom(emailRemetente);
			email.setSubject("Contato do Formulário - PetGoHome");
			email.setMsg(mensagemEmailGenerica(nome, mensagem, telefone));
			email.addTo("petgohome@gmail.com");
			email.send();
			System.out.println("Envio de form para PetGoHome!");

			return true;

		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
		return false;

	}

	public static String mensagemEmailGenerica(String nome,
			String mensagemDoForm, String telefone) {

		Date data = new Date(System.currentTimeMillis());

		String mensagem = "[PetGoHome - Contato de Formulário] "
				+ "\n"
				+ "\nEsta é uma mensagem do formulário do PetGoHome. Leia a seguir:"
				+ "\n" + "\nNome: " + nome + "." + "\nTelefone: " + telefone
				+ "." + "\n" + "\nMENSAGEM: " + mensagemDoForm + "\n"
				+ "\nA data de envio da mensagem foi: " + data + ".";
		return mensagem;

	}

	public static String emailSenhaAlterada(String novaSenha, Pessoa p) {

		String mensagem = "[PetGoHome - Security Message] "
				+ "\n"
				+ "\nCaro "
				+ p.getNome()
				+ ", você alterou sua senha."
				+ "\nNa próxima vez que fizer o login no site, utilize as seguintes informações:"
				+ "\n" + "\nLogin: " + p.getLogin() + "\nSenha: " + novaSenha
				+ "\n" + "\nO PetGoHome agradeçe o seu contato.";
		return mensagem;

	}

	public static String geraSenhaQualquer() {

		String letras = "ABCDEFGHIJKLMNOPQRSTUVYWXZ1234567890#$@";

		Random random = new Random();

		String armazenaChaves = "";
		int index = -1;

		for (int i = 0; i < 8; i++) {
			index = random.nextInt(letras.length());
			armazenaChaves += letras.substring(index, index + 1);
		}
		System.out.println("Gerou nova senha: " + armazenaChaves);

		return armazenaChaves;
	}

	public static boolean enviarEmailContato(String nome,
			String emailRemetente, String telefone, String emailLocalizaPet,
			String mensagem, String tagDoPet) {
		try {

			Email email = new SimpleEmail();
			email.setDebug(true);
			email.setSmtpPort(578);
			email.setHostName("smtp.gmail.com");
			email.setAuthentication("petgohome@gmail.com", "quartzo102");
			email.setSSLOnConnect(true);
			email.setFrom(emailRemetente);
			email.setSubject("Localização de Pet - PetGoHome");
			email.setMsg(mensagemLocalizadoPet(nome, mensagem, telefone,
					emailLocalizaPet, tagDoPet));
			email.addTo(emailLocalizaPet);
			email.send();
			System.out.println("Envio de form para PetGoHome!");

			return true;

		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
		return false;

	}

	public static String mensagemLocalizadoPet(String nome,
			String mensagemDoForm, String telefone, String emailLocalizaPet,
			String tagDoPet) {

		Date data = new Date(System.currentTimeMillis());

		String mensagem = "[PetGoHome - Detalhes de localização de PET] "
				+ "\n"
				+ "\nUma pessoa pesquisou a Tag do seu Pet no sistema:"
				+ "\n"
				+ "\nNome: "
				+ nome
				+ "."
				+ "\nTelefone: "
				+ telefone
				+ "."
				+ "\nTAG: "
				+ tagDoPet
				+ "."
				+ "\n"
				+ "\nMENSAGEM: "
				+ mensagemDoForm
				+ "\n"
				+ "\nA data de envio da mensagem foi: "
				+ data
				+ "."
				+ "\n"
				+ "\nRecomenda-se que entre em contato com a pessoa que localizou seu pet de forma moderada. Peça detalhes do seu Pet (Foto, características físicas) etc."
				+ "\n"
				+ "\nO PetGoHome deseja que seu Pet possa ser devolvido com sucesso."
				+ "\n"
				+ "\nSe o seu Pet não se perdeu, ignore esta mensagem. Obrigado!";
		return mensagem;

	}

	//BANNER
	
	public static void salvarBanner(Banner rc) {

		EntityManager manager = factory.createEntityManager();
		BannerDAO rcDao = new BannerDAO(manager);
		manager.getTransaction().begin();
		rcDao.salvar(rc);
		manager.getTransaction().commit();
		manager.close();

	}
	public static void alterarBanner(Banner rc) {
		
		EntityManager manager = factory.createEntityManager();
		BannerDAO rcDao = new BannerDAO(manager);
		manager.getTransaction().begin();
		rcDao.alterar(rc);
		manager.getTransaction().commit();
		manager.close();
		
	}
	public static void salvarHistoricoBanners(HistoricoBanner rc) {

		EntityManager manager = factory.createEntityManager();
		HistoricoBannerDao rcDao = new HistoricoBannerDao(manager);
		manager.getTransaction().begin();
		rcDao.salvar(rc);
		manager.getTransaction().commit();
		manager.close();

	}
	public static List<HistoricoBanner> buscarHistoricoBannerPorIdBanner(
            long idHistoricoBanner) {
		//Aqui traz a lista completa com todos o historicos com todas as fotos
    EntityManager manager = factory.createEntityManager();
    HistoricoBannerDao caoDao = new HistoricoBannerDao(manager);
    return caoDao.buscarHistoricoBannerPorBanner(idHistoricoBanner);
}
	public static HistoricoBanner buscarSimplesHistoricoBannerPorIdBanner(
			long idHistoricoBanner) {
		//Aqui ele traz apenas o Historico especifico pelo ID
		EntityManager manager = factory.createEntityManager();
		HistoricoBannerDao caoDao = new HistoricoBannerDao(manager);
		return caoDao.buscarPorId(idHistoricoBanner);
	}
	public static Banner buscarBannerPorId(
			long idBanner) {
		EntityManager manager = factory.createEntityManager();
		BannerDAO caoDao = new BannerDAO(manager);
		
		Banner x = new Banner();
		
		manager.getTransaction().begin();
		x = caoDao.buscarBanner(idBanner);
		manager.getTransaction().commit();
		manager.close();
		return x;
 
	}
	public static void alterarHistoricoBanner(HistoricoBanner rc) {
		
		EntityManager manager = factory.createEntityManager();
		HistoricoBannerDao rcDao = new HistoricoBannerDao(manager);
		manager.getTransaction().begin();
		rcDao.alterar(rc);
		manager.getTransaction().commit();
		manager.close();
		
	}
	
}
