package com.example.gamezy

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.gamezy.databinding.FragmentFavoritesBinding

class FavoritesFragment : Fragment() {

    private var _binding: FragmentFavoritesBinding? = null
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentFavoritesBinding.inflate(inflater, container, false)

        val favorites = listOf(
            NewsItem(
                id = 8,
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
                imageRes = R.drawable.fallout_new_vegas,
                isFavorite = true
            ),
            NewsItem(
                id = 9,
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
                id = 1,
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
                imageRes = R.drawable.mortal_shell,
                isFavorite = true
            ),
            NewsItem(
                id = 4,
                title = "Hollow Knight",
                source = "10$",
                content = "Hollow Knight es un metroidvania de acción y exploración ambientado en Hallownest, un vasto reino subterráneo en ruinas. Controlas a un pequeño caballero silencioso que viaja a través de túneles, ciudades olvidadas, bosques fúngicos y abismos infestados de criaturas extrañas.\n" +
                        "El combate es preciso y desafiante: atacas con tu aguijón, esquivas, haces saltos precisos y usas habilidades especiales basadas en “Alma”, un recurso que obtienes golpeando enemigos. A medida que avanzas, encuentras hechizos, movimientos nuevos, mejoras permanentes y amuletos que cambian tu estilo de juego.\n" +
                        "La exploración es completamente abierta: el mundo está lleno de secretos, rutas alternativas, jefes ocultos y zonas que requieren habilidades nuevas para desbloquear. El mapa es extenso y laberíntico, con un fuerte enfoque en descubrimiento y curiosidad.\n" +
                        "La historia es sutil y atmosférica: no se cuenta de forma directa, sino mediante diálogos enigmáticos, restos de civilizaciones caídas y pistas dispersas. Todo está acompañado por una banda sonora emocional y un estilo visual dibujado a mano muy detallado.\n" +
                        "Es un juego exigente pero justo, que recompensa la paciencia, la observación y la habilidad, ofreciendo una aventura profunda, melancólica y llena de misterios por resolver. Si quieres, puedo hacer una versión más corta, más larga o con enfoque en jugabilidad, historia o dificultad.",
                publishTime = "metroivania, 2D y Combate",
                category = "VideoGames",
                imageRes = R.drawable.hollow_knight,
                isFavorite = true
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
                imageRes = R.drawable.fallout_3,
                isFavorite = true
            ),
            NewsItem(
                id = 6,
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
                isFavorite = true
            ),
        )

        binding.recyclerViewFavorites.layoutManager = LinearLayoutManager(requireContext())
        binding.recyclerViewFavorites.adapter = NewsAdapter(favorites)

        return binding.root
    }


    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}
