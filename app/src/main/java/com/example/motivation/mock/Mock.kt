package com.example.motivation.mock

import com.example.motivation.utils.MotivationConstants
import kotlin.random.Random

data class Phrase (val description: String, val category: Int)

class Mock {

    private val ALL = MotivationConstants.INDEX_PHRASE.ALL_MESSAGE
    private  val SUNNY = MotivationConstants.INDEX_PHRASE.SUNNY_MESSAGE
    private val HAPPY = MotivationConstants.INDEX_PHRASE.HAPPY_MESSAGE

    private val mListPhrases: List<Phrase> = listOf(
        Phrase("Não sabendo que era impossível, foi lá e fez.", HAPPY),
        Phrase("Você não é derrotado quando perde, você é derrotado quando desiste!", HAPPY),
        Phrase("Quando está mais escuro, vemos mais estrelas!", HAPPY),
        Phrase("Insanidade é fazer sempre a mesma coisa e esperar um resultado diferente.", HAPPY),
        Phrase("Não pare quando estiver cansado, pare quando tiver terminado.", HAPPY),
        Phrase("O que você pode fazer agora que tem o maior impacto sobre o seu sucesso?", HAPPY),
        Phrase("A melhor maneira de prever o futuro é inventá-lo.", SUNNY),
        Phrase("Você perde todas as chances que você não aproveita.", SUNNY),
        Phrase("Fracasso é o condimento que dá sabor ao sucesso.", SUNNY),
        Phrase(" Enquanto não estivermos comprometidos, haverá hesitação!", SUNNY),
        Phrase("Se você não sabe onde quer ir, qualquer caminho serve.", SUNNY),
        Phrase("Se você acredita, faz toda a diferença.", SUNNY),
        Phrase("Riscos devem ser corridos, porque o maior perigo é não arriscar nada!", SUNNY)
    )

    fun getPhrase(category: Int): String{
        val filteredListPhrase = mListPhrases.filter { it.category == category || category == ALL }
        val random = Random.nextInt(filteredListPhrase.size)
        return filteredListPhrase[random].description
    }


}