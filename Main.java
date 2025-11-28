import controller.DenunciaController;
import model.Denuncia;

public class Main {
    public static void main(String[] args) {

        DenunciaController controller = new DenunciaController();

        System.out.println("=== TESTE DE CRIAR DENÚNCIA ===");
        String resultado = controller.criarDenuncia(
                "Buraco na Avenida",
                "Existe um buraco grande na rua que está causando acidentes",
                "Infraestrutura",
                "Av. Rui Barbosa, 123",
                "2025-11-24"
        );
        System.out.println(resultado);

        System.out.println("\n=== TESTE DE LISTAR TODAS ===");
        for (Denuncia d : controller.listar()) {
            System.out.println(
                d.getId() + " | " + d.getTitulo() + " | " + d.getStatus()
            );
        }

        System.out.println("\n=== TESTE DE EDITAR DENÚNCIA ===");
        if (!controller.listar().isEmpty()) {
            Denuncia d = controller.listar().get(0);
            String editResult = controller.editarDenuncia(
                    d.getId(),
                    "Buraco corrigido parcialmente",
                    "O buraco foi parcialmente tapado, ainda precisa de reparo completo",
                    "Infraestrutura",
                    "Av. Rui Barbosa, 123",
                    "2025-11-25"
            );
            System.out.println(editResult);
        }

        System.out.println("\n=== TESTE DE REMOVER DENÚNCIA ===");
        if (!controller.listar().isEmpty()) {
            Denuncia d = controller.listar().get(0);
            String removeResult = controller.removerDenuncia(d.getId());
            System.out.println(removeResult);
        }

        System.out.println("\n=== TESTE FINAL DE LISTAGEM ===");
        for (Denuncia d : controller.listar()) {
            System.out.println(
                d.getId() + " | " + d.getTitulo() + " | " + d.getStatus()
            );
        }

        System.out.println("\nTeste finalizado.");
    }
}