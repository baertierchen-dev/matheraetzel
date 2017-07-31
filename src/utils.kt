
import java.io.File





open class utils {
    var zahlA: MutableList<Int> = (1..1000).toMutableList()
    var zahlB: MutableList<Int> = (1..1000).toMutableList()

    var produkt = mutableListOf<Int>()
    var pair = mutableListOf<Pair<Int, Int>>()
    var primeNumbers = mutableListOf<Int>()

    val file: File = File("resources/pairs")


    fun calcPrime() {
        val yeah = 1000
        val isPrime = Array(yeah, { true })
        (2..yeah - 1).forEach {
            n ->
            if (isPrime[n]) {
//                println(n)
                (n..yeah - 1 step n).forEach { isPrime[it] = false }
            }
        }
    }

    fun fillPair() {
        for (i in zahlA) {
            for (j in zahlB) {
                pair.add(Pair(i, j))
            }

        }
        val x: Set<Pair<Int, Int>> = pair.toSortedSet(compareBy({ it.first + it.second }, { it.first }, { it.second }))
        pair = x.toMutableList()
    }

    fun removeSame() {
        pair.toMutableSet()
        val full = pair.size
        var size = pair.size
        var i = 0
        var j = 0
        while (i < pair.size) {
            while (j < pair.size) {
                if(j<=i){
                    j++
                }else if (pair[i] == Pair(pair[j].second, pair[j].first)) {
                    pair.removeAt(pair.indexOf(pair[j]))
                    size = pair.size
                    var percent: Double = (100 / full.toDouble()) * (size - 1)
                    percent = Math.floor(percent * 100) / 100
                    println("[$percent%] of lines are left.")
                    i++
                    if(j>i){
                        j=i+1
                    }
                    break
                } else if (pair[i].first == pair[i].second) {
                    i++
                    if(j>i){
                        j=i+1
                    }
                    break
                } else
                    j++
            }
        }
    }

    fun multiplayer() {
        for (i in zahlA) {
            for (j in zahlB) {
                produkt.add(i * j)
            }
        }
    }


    fun removeLines(fileName: String, startLine: Int, numLines: Int) {
        require(!fileName.isEmpty() && startLine >= 1 && numLines >= 1)
        val f = File("resources/" + fileName)
        if (!f.exists()) {
            println("$fileName does not exist")
            return
        }
        var lines = f.readLines()
        val size = lines.size
        if (startLine > size) {
            println("The starting line is beyond the length of the file")
            return
        }
        var n = numLines
        if (startLine + numLines - 1 > size) {
            println("Attempting to remove some lines which are beyond the end of the file")
            n = size - startLine + 1
        }
        lines = lines.take(startLine - 1) + lines.drop(startLine + n - 1)
        val text = lines.joinToString(System.lineSeparator())
        f.writeText(text)
    }

    fun printFile(fileName: String, message: String) {
        require(!fileName.isEmpty())
        val f = File("resources/" + fileName)
        if (!f.exists()) {
            println("$fileName does not exist")
            return
        }
        println("\nContents of $fileName $message:\n")
        f.forEachLine { println(it) }
    }

    fun pairsInText(): MutableList<Pair<Int, Int>> {

        var pairsText = mutableListOf<Pair<Int, Int>>()
        var lines = this.file.readLines()
        var regex = """\((\d*),\s(\d*)\)""".toRegex()
        for (i in lines) {
            pairsText.add(Pair(
                    regex.matchEntire(i)?.groups?.get(1)?.value?.toInt(),
                    regex.matchEntire(i)?.groups?.get(2)?.value?.toInt()
            ) as Pair<Int, Int>)
        }
        return pairsText;
    }

}