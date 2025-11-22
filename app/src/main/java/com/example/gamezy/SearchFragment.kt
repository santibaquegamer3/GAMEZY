package com.example.gamezy

import android.os.Bundle
import android.text.Editable
import android.text.TextWatcher
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.gamezy.databinding.FragmentSearchBinding

class SearchFragment : Fragment() {

    private var _binding: FragmentSearchBinding? = null
    private val binding get() = _binding!!
    private lateinit var allArticles: List<NewsItem>
    private lateinit var searchAdapter: NewsAdapter

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentSearchBinding.inflate(inflater, container, false)

        // Base de datos de artículos para búsqueda
        allArticles = listOf(
            NewsItem(
                id = 5,
                title = "Slime Rancher",
                source = "10$",
                content = "Slime Rancher es una encantadora experiencia sandbox en primera persona. Juegas como Beatrix LeBeau, una joven ranchera que parte hacia una vida a mil años luz de la Tierra, en un lugar llamado la Lejana, Lejana Pradera (“Far, Far Range”). Cada día trae nuevos retos y oportunidades peligrosas mientras intentas hacerte rica criando slimes.\n" +
                        "\n" +
                        "Tus tareas incluyen: recolectar slimes de colores, cultivar plantas, cosechar recursos y explorar zonas salvajes usando tu “vacpack” (una especie de mochila-vacío muy versátil).",
                publishTime = "Exploracion, Mundo Abierto y Gestion",
                category = "VideoGames",
                imageRes = R.drawable.slime_rancher_icon
            ),
            NewsItem(
                id = 6,
                title = "Dead Cells",
                source = "15$",
                content = "Exploras un castillo enorme que cambia constantemente, enfrentándote a guardianes en combates 2D con un estilo “souls-lite”. \n" +
                        "\n" +
                        "No hay puntos de control: mueres, reapareces, aprendes y vuelves a intentar. \n" +
                        "\n" +
                        "Controlas un experimento alquímico fallido: eres inmortal, pero tu cuerpo no lo es, así que tienes que “poseer” otros cuerpos para moverte, luchar y explorar. \n" +
                        "\n" +
                        "Al morir, vuelves al inicio (mazmorra) y debes conseguir un nuevo anfitrión para continuar. \n" +
                        "\n" +
                        "Es un “rogueVANIA”: mezcla un mundo interconectado con caminos ramificados, habilidades desbloqueables y la amenaza constante de muerte permanente. \n" +
                        "\n" +
                        "Conservarás algo de progreso entre partidas: desbloqueas nuevos caminos, niveles, mutaciones, armas y habilidades para futuras corridas. \n" +
                        "\n" +
                        "El combate es duro pero justo: controles muy responsivos, enemigos desafiantes y una mecánica de “rodar” para escapar de situaciones peligrosas.",
                publishTime = "metroidvania y 2D",
                category = "VideoGames",
                imageRes = R.drawable.dead_cells_icon
            ),
            NewsItem(
                id = 7,
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
                id = 8,
                title = "Balatro",
                source = "15$",
                content = "Balatro es un roguelike tipo deck-builder inspirado en el póker. En el juego, debes formar manos de póker “ilegales” (no apuestas reales) y combinar esas manos con comodines (jokers) para crear sinergias poderosas. Ganas “fichas” (chips) al vencer las ciegas (blinds) mientras avanzas en tu partida.\n" +
                        "\n" +
                        "Hay muchos elementos para variar tu estrategia: diferentes barajas, muchos jokers con habilidades únicas, cartas de tarot, cartas de “planeta” y vales que te dan mejoras permanentes. A medida que juegas, puedes desbloquear nuevas cartas, descubrir secretos y construir combinaciones cada vez más locas.\n" +
                        "\n" +
                        "El estilo visual es píxel art con una vibra psicodélica, acompañado por una banda sonora synthwave que ayuda a meterte en un estado de “flujo” roguelike. También puedes ver tus estadísticas de juego: tus mejores manos, tus jokers más usados, y más.",
                publishTime = "Juego de Azar y Estrategia",
                category = "VideoGames",
                imageRes = R.drawable.balatro_icon
            ),
            NewsItem(
                id = 9,
                title = "The Forest",
                source = "10$",
                content = "The Forest te pone como único sobreviviente de un accidente de avión en una península misteriosa. Debes buscar comida, agua y recursos mientras construyes refugios, defensas y armas primitivas para mantenerte con vida. El entorno es completamente interactivo: puedes talar árboles, crear estructuras complejas y explorar libremente tanto la superficie como un enorme sistema de cuevas subterráneas.\n" +
                        "\n" +
                        "La mayor amenaza es una tribu de caníbales y mutantes que actúa con cierta inteligencia: patrullan, observan, investigan y reaccionan a tus acciones. Puedes enfrentarlos directamente, evitar el contacto con sigilo o reforzar tu base para resistir sus ataques, especialmente durante la noche, cuando la tensión aumenta.\n" +
                        "\n" +
                        "La exploración juega un papel central. En las cuevas encontrarás peligros mucho mayores, secretos y partes importantes de la historia, que gira en torno a descubrir qué le ocurrió a los habitantes del lugar y cuál es el origen de las criaturas. El clima de horror, la sensación de vulnerabilidad y la libertad para construir y sobrevivir hacen que cada partida sea distinta.",
                publishTime = "Supervivencia, Terror y Mundo Abierto",
                category = "VideoGames",
                imageRes = R.drawable.the_forest
            ),
            NewsItem(
                id = 10,
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
                imageRes = R.drawable.sifu

            ),
            NewsItem(
                id = 2,
                title = "Grounded",
                source = "25$",
                content = "Grounded es un juego de supervivencia en primera (y también tercera) persona donde tu personaje ha sido reducido al tamaño de una hormiga y debe sobrevivir en un jardín gigantesco. Tienes que recolectar recursos, beber agua, comer y construir todo tipo de armas, herramientas y bases para protegerte. En el patio acechan insectos gigantes —como arañas, hormigas, abejas— que pueden ser enemigos, pero también algunas especies te ayudan (por ejemplo, ciertos insectos te indican dónde hay comida).\n" +
                        "\n" +
                        "Puedes jugar solo o con hasta tres amigos en modo cooperativo. El mundo es muy diverso: hay zonas como el fondo de un estanque, las cavernas de un termitero o la arena del cajón de arena, y ninguna parte es completamente segura, ni siquiera tu base. Además, puedes mejorar a tu personaje con “mutaciones” y “milk molars” para activar bonificaciones mientras mejoras tu equipamiento.\n" +
                        "\n" +
                        "La historia va revelándose a medida que exploras: te preguntas por qué estás tan pequeño, quién lo hizo y cómo volver a tu tamaño normal. El ambiente mezcla tensión, exploración, construcción y combate, y la sensación de vulnerabilidad es constante.",
                publishTime = "Mundo Abierto, supervivencia y Combate ",
                category = "VideoGames",
                imageRes = R.drawable.grounded
            ),
            NewsItem(
                id = 3,
                title = "Blasphemous",
                content = "Blasphemous es un juego de acción y plataformas 2D con elementos metroidvania, ambientado en el mundo oscuro y retorcido de Cvstodia. Juegas como el Penitent One, un guerrero silencioso que empuña la espada Mea Culpa y recorre una tierra marcada por la penitencia, el fanatismo religioso y la corrupción milagrosa.\n" +
                        "\n" +
                        "El combate es exigente: puedes atacar, hacer parrys, ejecutar enemigos y usar habilidades especiales gastando “fervor” que obtienes al luchar. Al morir reapareces en puntos de control, dejando atrás una “culpa” que reduce tus recursos hasta que la recuperas. La exploración es fundamental: el mapa está lleno de caminos opcionales, secretos, atajos y zonas que requieren habilidades nuevas para avanzar.\n" +
                        "\n" +
                        "Su estilo pixel art es muy detallado y grotesco, con jefes impactantes y una narrativa cargada de simbolismo religioso y temas de culpa, sacrificio y redención. Es un juego retador, atmosférico y perfecto para quienes buscan un metroidvania oscuro con combate profundo.",
                source = "10$",
                publishTime = "retroivania, exploracion y combate",
                category = "VideoGames",
                imageRes = R.drawable.blasphemous
            ),
            NewsItem(
                id = 4,
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
                imageRes = R.drawable.dead_island_2
            ),
            NewsItem(
                id = 5,
                title = "Fallout 3",
                source = "15$",
                content = "Fallout 3 es un RPG de acción en primera persona ambientado en un mundo postapocalíptico devastado por la guerra nuclear. El juego se desarrolla principalmente en las ruinas de Washington D.C. y sus alrededores, conocido como el “Capital Wasteland”. Empiezas tu aventura saliendo del Refugio 101, donde creciste, con la misión de encontrar a tu padre.\n" +
                        "\n" +
                        "A lo largo del juego exploras un mundo abierto lleno de facciones como supermutantes y la Hermandad del Acero. Tienes libertad para tomar decisiones morales que afectan la historia, y hay muchas misiones secundarias, personajes únicos y situaciones dilema.\n" +
                        "\n" +
                        "El combate combina disparos en tiempo real con un sistema llamado V.A.T.S., que te permite pausar el tiempo para apuntar a partes específicas del cuerpo de los enemigos y planear tus ataques de forma más estratégica. También hay muchos tipos de armas, desde pistolas hasta armamento más pesado y experimental.\n" +
                        "\n" +
                        "Tu personaje sube de nivel, puedes personalizar sus habilidades (como fuerza, carisma, agilidad, percepción, etc.) y distribuir puntos para especializarte en lo que quieras: combate, sigilo, diálogo, exploración. Sobrevivir implica no solo pelear, sino gestionar recursos como munición, agua y comida, y enfrentarte a peligros como la radiación.\n" +
                        "\n" +
                        "La narrativa es muy rica: tu búsqueda personal se mezcla con la historia más amplia del Yermo, incluidos secretos oscuros del Refugio 101, conspiraciones y el destino de las comunidades que sobreviven. El mundo tiene una atmósfera de soledad, desesperanza y melancolía, pero también momentos de humor negro.\n" +
                        "\n" +
                        "Además, el juego incluye contenido descargable (DLC) que expande la historia con nuevas áreas y aventuras, lo que añade muchas más horas de juego si quieres ir más allá de la campaña principal.",
                publishTime = "Shoter, RPG y Mundo Abierto",
                category = "VideoGames",
                imageRes = R.drawable.fallout_3

            ),
            NewsItem(
                id = 6,
                title = "Hollow Knight",
                source = "10$",
                content = "Hollow Knight es un metroidvania de acción y exploración ambientado en Hallownest, un vasto reino subterráneo en ruinas. Controlas a un pequeño caballero silencioso que viaja a través de túneles, ciudades olvidadas, bosques fúngicos y abismos infestados de criaturas extrañas.\n" +
                        "El combate es preciso y desafiante: atacas con tu aguijón, esquivas, haces saltos precisos y usas habilidades especiales basadas en “Alma”, un recurso que obtienes golpeando enemigos. A medida que avanzas, encuentras hechizos, movimientos nuevos, mejoras permanentes y amuletos que cambian tu estilo de juego.\n" +
                        "La exploración es completamente abierta: el mundo está lleno de secretos, rutas alternativas, jefes ocultos y zonas que requieren habilidades nuevas para desbloquear. El mapa es extenso y laberíntico, con un fuerte enfoque en descubrimiento y curiosidad.\n" +
                        "La historia es sutil y atmosférica: no se cuenta de forma directa, sino mediante diálogos enigmáticos, restos de civilizaciones caídas y pistas dispersas. Todo está acompañado por una banda sonora emocional y un estilo visual dibujado a mano muy detallado.\n" +
                        "Es un juego exigente pero justo, que recompensa la paciencia, la observación y la habilidad, ofreciendo una aventura profunda, melancólica y llena de misterios por resolver. Si quieres, puedo hacer una versión más corta, más larga o con enfoque en jugabilidad, historia o dificultad.",
                publishTime = "metroivania, 2D y Combate",
                category = "VideoGames",
                imageRes = R.drawable.hollow_knight
            ),
            NewsItem(
                id = 7,
                title = "Mortal Shell",
                source = "15$",
                content = "Mortal Shell es un RPG de acción tipo soulslike ambientado en un mundo oscuro y destrozado donde tu cordura y resistencia son puestas a prueba. En lugar de tener una única clase, puedes “poseer” los cuerpos de guerreros caídos, llamados “shells” (“cáscaras mortales”), cada uno con su propio estilo de combate y habilidades.\n" +
                        "\n" +
                        "El combate es estratégico y deliberado: debes elegir cuándo atacar, calcular tus parries para devolver golpes poderosos y usar una habilidad llamada “endurecimiento” para convertirte temporalmente en piedra y bloquear ataques o golpear con más fuerza. Cuando tu “shell” muere, eres expulsado de él y tienes la oportunidad de recuperarlo, lo que añade un riesgo extra.\n" +
                        "\n" +
                        "Exploras entornos oscuros y visceralmente diseñados, enfrentándote a enemigos devotos de dioses misteriosos. Hay santuarios ocultos, maestros del combate, y un sistema de progresión donde mejoras las “shells” que vas encontrando y sus armas. El mundo es implacable, pero el juego recompensa la paciencia y la precisión: cada victoria tiene un peso real.\n" +
                        "\n" +
                        "En resumen: es un desafío intenso, muy técnico, ideal para quienes disfrutan de los juegos tipo Souls con un giro en la mecánica de cambio de cuerpo y con un estilo maduro y sombrío.",
                publishTime = "DarkSouls, Combate y Mundo Abierto",
                category = "VideoGames",
                imageRes = R.drawable.mortal_shell
            ),
            NewsItem(
                id = 8,
                title = "Dishonored",
                source = "10$",
                content = "Dishonored es un juego de acción y sigilo en primera persona ambientado en Dunwall, una ciudad industrial corroída por la peste, la corrupción política y tecnologías extrañas impulsadas por aceite de ballena. Controlas a Corvo Attano, el guardaespaldas de la emperatriz, injustamente acusado de su asesinato. Con la ayuda de un grupo rebelde y poderes sobrenaturales otorgados por una figura enigmática llamada El Forastero, buscas vengarte y desentrañar la conspiración detrás del crimen.\n" +
                        "\n" +
                        "Puedes afrontar cada misión como quieras: usando sigilo absoluto, eliminaciones no letales, o un estilo agresivo y violento. Tus decisiones cambian el “caos” del mundo, afectando la historia, el ambiente y el destino de varios personajes. Entre tus habilidades están teletransportarte, detener el tiempo, controlar criaturas y usar armas como ballestas, espadas y minas.\n" +
                        "\n" +
                        "El diseño de niveles es abierto y está lleno de rutas alternativas, secretos, personajes con motivaciones propias y formas creativas de completar los objetivos. La atmósfera mezcla steampunk, magia oscura y decadencia urbana, creando un mundo muy inmersivo. En conjunto, ofrece libertad, creatividad y consecuencias reales según cómo eliges actuar.",
                publishTime = "Combate, RPG y Mundo Abierto",
                category = "VideoGames",
                imageRes = R.drawable.dishonored
            ),
            NewsItem(
                id = 9,
                title = "Fallout New Vegas",
                source = "15$",
                content = "Fallout: New Vegas es un RPG de acción ambientado en un desierto postapocalíptico, alrededor de Las Vegas (rebautizada “New Vegas”) y sus alrededores. Juegas como un mensajero (“Courier”) que es traicionado, recibe un disparo en la cabeza y es dado por muerto, pero sobrevive y se despierta en la pequeña ciudad de Goodsprings. A partir de allí, entras en medio de un conflicto entre varias facciones poderosas que compiten por el control del Mojave y de Nueva Vegas.\n" +
                        "\n" +
                        "El mundo del juego es grande y abierto: puedes explorar pueblos del yermo, la presa Hoover, la famosa franja de casinos y muchos otros lugares peligrosos. Hay facciones como la República de Nueva California (NCR), la Legión de César y el misterioso líder de New Vegas, el Sr. House, y las decisiones que tomas influyen mucho en cómo se desarrolla la historia.\n" +
                        "\n" +
                        "El combate combina disparos clásicos con un sistema de apuntado estratégico (V.A.T.S.), y puedes relacionarte con muchos personajes a través de diálogos ramificados con consecuencias reales. También hay un modo “Hardcore” para quienes quieren una experiencia más realista (gestionando hambre, sed, sueño, etc.).\n" +
                        "\n" +
                        "La narrativa es muy rica: tus elecciones importan, puedes aliarte, traicionar o mantener tu independencia, y hay múltiples finales posibles según a quién apoyes. Es un juego con mucho peso de rol, exploración profunda y decisiones morales, idóneo para quienes disfrutan de historias complejas y libertad para moldear su propio camino.",
                publishTime = "Shoter, RPG y Mundo Abierto",
                category = "VideoGames",
                imageRes = R.drawable.fallout_new_vegas
            )
        )

        setupSearch()
        return binding.root
    }

    private fun setupSearch() {
        // Configurar RecyclerView
        binding.recyclerViewSearch.layoutManager = LinearLayoutManager(requireContext())
        searchAdapter = NewsAdapter(allArticles)
        binding.recyclerViewSearch.adapter = searchAdapter

        // Configurar búsqueda en tiempo real
        binding.searchBar.addTextChangedListener(object : TextWatcher {
            override fun beforeTextChanged(s: CharSequence?, start: Int, count: Int, after: Int) {}
            
            override fun onTextChanged(s: CharSequence?, start: Int, before: Int, count: Int) {
                performSearch(s.toString())
            }
            
            override fun afterTextChanged(s: Editable?) {}
        })
    }

    private fun performSearch(query: String) {
        if (query.isBlank()) {
            // Mostrar todos los artículos si no hay búsqueda
            searchAdapter = NewsAdapter(allArticles)
        } else {
            // Filtrar artículos basado en la consulta
            val filteredArticles = allArticles.filter { article ->
                article.title.contains(query, ignoreCase = true) ||
                article.content.contains(query, ignoreCase = true) ||
                article.source.contains(query, ignoreCase = true) ||
                article.category.contains(query, ignoreCase = true)
            }
            searchAdapter = NewsAdapter(filteredArticles)
        }
        
        binding.recyclerViewSearch.adapter = searchAdapter
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}
