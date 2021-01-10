fun main(args: Array<String>) {
    val players = arrayListOf(
        Player("Player 1", 30),
        Player("Player 2", 95),
        Player("Player 3", 95),
        Player("Player 4", 10)
    )
    if (validatePlayerSize(players.size) && validatePlayersAbility(players)) {
        initTournament(players)
    } else {
        print("Players number or ability is incorrect")
    }
}

fun initTournament(players: List<Player>) {
    val matches = createMatches(players)
    if (matches.size == 1) {
        print("The winner is: ${matches[0].getWinner().name}")
    } else {
        val winnerPlayers = loadWinners(matches)
        initTournament(winnerPlayers)
    }
}

fun loadWinners(matches: List<Match>): List<Player> {
    val players = arrayListOf<Player>()
    matches.forEach {
        players.add(it.getWinner())
    }
    return players
}

fun createMatches(players: List<Player>): List<Match> {
    val matches = arrayListOf<Match>()
    for (i in 0..players.size.minus(1) step 2) {
        matches.add(Match(players[i], players[i.plus(1)]))
    }
    return matches
}

fun validatePlayerSize(size: Int): Boolean {
    var number: Int = size
    if (number == 0)
        return false

    while (number != 1) {
        if (number % 2 != 0)
            return false
        number /= 2
    }
    return true
}

fun validatePlayersAbility(players: List<Player>): Boolean {
    var isValid = true
    players.forEach {
        if (it.abilityLevel < 0 || it.abilityLevel > 100) {
            isValid = false
            return@forEach
        }
    }
    return isValid
}
