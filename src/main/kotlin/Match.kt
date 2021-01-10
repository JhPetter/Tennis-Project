import kotlin.random.Random

class Match(var firstPlayer: Player, var secondPlayer: Player) {
    fun getWinner(): Player {
        return when {
            firstPlayer.abilityLevel > secondPlayer.abilityLevel -> firstPlayer
            firstPlayer.abilityLevel == secondPlayer.abilityLevel -> getLuckyWinner()
            else -> secondPlayer
        }
    }

    private fun getLuckyWinner(): Player {
        val luckyFirstPlayer = addLuckyPoint()
        val luckySecondPlayer = addLuckyPoint()
        return if (luckyFirstPlayer > luckySecondPlayer) firstPlayer else secondPlayer
    }

    private fun addLuckyPoint(): Int = Random.nextInt(10) + 1
}