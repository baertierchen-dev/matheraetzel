fun main(args: Array<String>) {

    val u = utils()
    u.multiplayer()
    u.fillPair()
    u.calcPrime()
//    u.file.printWriter().use { out ->
//        u.pair.forEach {
//            out.println("${it}")
//        }
//    }
//    val pairs = u.pair
    var pairs = u.pairsInText()

    u.removeSame()
    u.file.printWriter().use { out ->
        u.pair.forEach {
            out.println("${it}")
        }
    }

//    var i =0
//    var size = pairs.size
//    var full = pairs.size
//    u.printFile("pairs", "before removal")

//    while(i < size){
//        val dummy = Pair(pairs[i].second, pairs[i].first)
//        if (pairs.contains(dummy)){
//            val lineI = pairs.indexOf(dummy)
//            u.removeLines("pairs", lineI+1, 1)
//            pairs = u.pairsInText()
//            var percent:Double = (100/ full.toDouble())*(size-1)
//            percent = Math.floor(percent * 100)/100
//            println("$percent% of lines are left. \nChecking ${size-1} of $full possible Pairs")
//            size--
////            pairs.remove(dummy)
//
//        }
//        i++
//    }


//    u.printFile("pairs", "after removal")


//
}
