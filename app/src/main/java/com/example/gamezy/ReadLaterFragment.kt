package com.example.gamezy

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.gamezy.databinding.FragmentReadLaterBinding

class ReadLaterFragment : Fragment() {

    private var _binding: FragmentReadLaterBinding? = null
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentReadLaterBinding.inflate(inflater, container, false)

        val savedArticles = listOf(
            NewsItem(
                id = 10,
                title = "Slime Rancher",
                source = "10$",
                content = "Slime Rancher es una encantadora experiencia sandbox en primera persona. Juegas como Beatrix LeBeau, una joven ranchera que parte hacia una vida a mil años luz de la Tierra, en un lugar llamado la Lejana, Lejana Pradera (“Far, Far Range”). Cada día trae nuevos retos y oportunidades peligrosas mientras intentas hacerte rica criando slimes.\n" +
                        "\n" +
                        "Tus tareas incluyen: recolectar slimes de colores, cultivar plantas, cosechar recursos y explorar zonas salvajes usando tu “vacpack” (una especie de mochila-vacío muy versátil).",
                publishTime = "Exploracion, Mundo Abierto y Gestion",
                category = "VideoGames",
                imageRes = R.drawable.slime_rancher_icon,
                isReadLater = true
            ),
            NewsItem(
                id = 11,
                title = "Resident Evil 4",
                source = "10$",
                content = "Controlas a Leon S. Kennedy, seis años después del desastre biológico de Raccoon City. \n" +
                        "\n" +
                        "Leon es enviado para rescatar a la hija del presidente de EE.UU., y su búsqueda lo lleva a una remota aldea europea. \n" +
                        "\n" +
                        "En esa aldea, los habitantes están infectados por un parásito llamado “Las Plagas”, lo que da lugar a una amenaza terrorífica. \n" +
                        "\n" +
                        "El juego combina acción con elementos de survival horror: debes gestionar tus recursos (munición, hierbas, etc.), y enfrentarte a enemigos peligrosos usando tanto armas como escondites. \n" +
                        "\n" +
                        "Tiene un estilo de cámara “por encima del hombro” que en su momento fue muy innovador. \n" +
                        "\n" +
                        "Es un clásico influyente en los videojuegos, reconocido por su narrativa, atmósfera de terror y mecánicas de juego.",
                publishTime = "Survivar Horror y Shoter",
                category = "VideoGames",
                imageRes = R.drawable.resident_evil_4

            ),
            NewsItem(
                id = 3,
                title = "Sifu",
                content = "Sifu es un juego de acción en tercera persona con combate de kung fu realista. Sigues el camino de la venganza tras la muerte de tu familia, enfrentándote a numerosos enemigos para cazarlos uno a uno.\n" +
                        "\n" +
                        "Cada vez que mueres, revives gracias a un amuleto mágico, pero al hacerlo envejeces, lo que afecta tu salud: con la edad obtienes golpes más poderosos, pero eres más débil a nivel de resistencia. También tienes un sistema de combate muy pulido: puedes golpear, esquivar, bloquear y hacer parrys, y debes usar el entorno a tu favor (objetos lanzables, bordes, ventanas) para sobrevivir.\n" +
                        "\n" +
                        "A medida que avanzas, desbloqueas habilidades del estilo Pak Mei Kung Fu. El diseño del juego te exige “aprender de los errores”: cada enfrentamiento es una oportunidad para mejorar, practicar tus técnicas y refinar tus combos.\n" +
                        "\n" +
                        "El mundo por el que te mueves tiene variedad: vas desde clubes nocturnos hasta galerías artísticas o edificios altos, y cada escenario ofrece posibilidades tácticas diferentes.",
                source = "20$",
                publishTime = "Accion, Aventura y Pelea",
                category = "VideoGames",
                imageRes = R.drawable.sifu,
                isReadLater = true
            ),
            NewsItem(
                id = 6,
                title = "Dead Island 2",
                source = "30$",
                content = "Dead Island 2 es un juego de rol y acción en primera persona ambientado en un Los Ángeles infectado por un virus zombie. Estás en medio de una epidemia violenta y sangrienta: debes eliminar hordas de zombis usando una gran variedad de armas cuerpo a cuerpo o a distancia, muchas de ellas modificables con efectos elementales.\n" +
                        "\n" +
                        "Tienes seis personajes jugables, cada uno con habilidades únicas, y puedes elegir entre bloquear ataques o esquivarlos para defenderte. El mundo está dividido en múltiples zonas que puedes explorar libremente, aunque necesitarás desbloquear puntos de viaje rápido para moverte más rápido.\n" +
                        "\n" +
                        "Hay un sistema muy visceral de desmembramiento (FLESH) que hace que los enfrentamientos sean cruentos y sangrientos, permitiéndote romper piel, huesos y órganos de los zombis con tus ataques.\n" +
                        "Además, el juego incluye un mecanismo tipo “deck-building”: recolectas cartas para mejorar tu personaje en varias categorías (habilidades activas, salud, daño, efectos especiales), lo que te permite crear distintos estilos de combate.\n" +
                        "\n" +
                        "La estética combina humor negro con terror de serie B, ofreciendo momentos exagerados y violentos, pero también diversión cooperativa si juegas con amigos.",
                publishTime = "Primera Persona, Zombies Y Survival",
                category = "VideoGames",
                imageRes = R.drawable.dead_island_2,
                isReadLater = true
            ),
            NewsItem(
                id = 7,
                title = "Grounded",
                source = "25$",
                content = "Grounded es un juego de supervivencia en primera (y también tercera) persona donde tu personaje ha sido reducido al tamaño de una hormiga y debe sobrevivir en un jardín gigantesco. Tienes que recolectar recursos, beber agua, comer y construir todo tipo de armas, herramientas y bases para protegerte. En el patio acechan insectos gigantes —como arañas, hormigas, abejas— que pueden ser enemigos, pero también algunas especies te ayudan (por ejemplo, ciertos insectos te indican dónde hay comida).\n" +
                        "\n" +
                        "Puedes jugar solo o con hasta tres amigos en modo cooperativo. El mundo es muy diverso: hay zonas como el fondo de un estanque, las cavernas de un termitero o la arena del cajón de arena, y ninguna parte es completamente segura, ni siquiera tu base. Además, puedes mejorar a tu personaje con “mutaciones” y “milk molars” para activar bonificaciones mientras mejoras tu equipamiento.\n" +
                        "\n" +
                        "La historia va revelándose a medida que exploras: te preguntas por qué estás tan pequeño, quién lo hizo y cómo volver a tu tamaño normal. El ambiente mezcla tensión, exploración, construcción y combate, y la sensación de vulnerabilidad es constante.",
                publishTime = "Mundo Abierto, supervivencia y Combate ",
                category = "VideoGames",
                imageRes = R.drawable.grounded,
                isReadLater = true
            )
        )

        binding.recyclerViewReadLater.layoutManager = LinearLayoutManager(requireContext())
        binding.recyclerViewReadLater.adapter = NewsAdapter(savedArticles)

        return binding.root
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}
