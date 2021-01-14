package com.company

import java.io.File

fun main(args: Array<String>) {
//    val array = arrayOf(4, 5, 2, 58, 85, 4, 8, 478, 1, 2, 1, 545, 836, 5, 47, 4, 54, 32, 3)
//    println("arr : ${array.contentToString()}")
//    reverse(array)
//    println("arr : ${array.contentToString()}")
//
//    println("max = ${getMax(array)}")
//    println("min = ${getMin(array)}")
//
//    val list = array.filter { isSimpleNumber(it) }
//    println("simpleArr : ${list.toString()}")
//
//    val fileList = mutableListOf<File>()
//    searchFiles(File("/home/armen"), fileList)
//
//    for (file in fileList) {
//        println(file.absolutePath)
//    }

    print(rep("26 B4 97 F3 9B 50 AA 26 12 65 B2 A5 8D 04 92 C4 F7 A0 63 5A"))

}

private fun getMin(arr: Array<Int>): Int {
    var min = arr[0]
    for (item in arr) {
        if (item < min) {
            min = item
        }
    }

    return min
}

private fun getMax(arr: Array<Int>): Int {
    var max = arr[0]
    for (item in arr) {
        if (item > max) {
            max = item
        }
    }

    return max
}

private fun swapMinToMax(arr: Array<Int>) {
    for (i in arr.indices) {
        for (j in i + 1 until arr.size) {
            var temp: Int
            if (arr[i] < arr[j]) {
                temp = arr[i]
                arr[i] = arr[j]
                arr[j] = temp
            }
        }
    }
}

private fun reverse(arr: Array<Int>) {
    for (i in arr.indices) {
        for (j in i + 1 until arr.size) {
            var temp: Int = arr[i]
            arr[i] = arr[j]
            arr[j] = temp
        }
    }
}

private fun isSimpleNumber(number: Int): Boolean {
    if (number <= 0) {
        return false
    }
    if (number == 1) {
        return true
    }

    var i = 2
    while (i * i <= number) {
        if (number % i == 0) {
            return false
        }
        i++
    }
    return true
}

private fun searchFiles(rootFile: File, fileList: MutableList<File>) {
    if (rootFile.isDirectory) {
        println("searching at : " + rootFile.absolutePath)
        val directoryFiles = rootFile.listFiles()
        if (directoryFiles != null) {
            for (file in directoryFiles) {
                if (file.isDirectory) {
                    searchFiles(file, fileList)
                } else {
                    if (file.name.endsWith(".png") || file.name.endsWith(".jpg")) {
                        fileList.add(file)
                    }
                }
            }
        }
    }
}


private fun calculateEms(ems: Int, text: String): String {
    if (ems > 0 && text != "") {
        var wordsCount = 0
        var lastSpacePosition = 0
        var sentence = ""

        for (i in text.indices) {
            wordsCount++
            if (text[i] == '\n') {
                wordsCount = 0
            }
            if (text[i] == ' ') {
                lastSpacePosition = i
            }
            if (wordsCount > ems) {
                if (text[i] == ' ') {
                    sentence += '\n'
                    lastSpacePosition = i
                    wordsCount = 0
                } else {
                    sentence += text[i]
                    sentence = replaceChar(sentence, '\n', lastSpacePosition)!!
                    wordsCount = if (sentence.length > lastSpacePosition + 1) {
                        sentence.length - lastSpacePosition - 1
                    } else {
                        sentence.length - lastSpacePosition
                    }
                }
                continue
            }
            sentence += text[i]
        }
        return sentence
    }
    return text
}

private fun replaceChar(str: String, ch: Char, position: Int): String? {
    return if (position < str.length) {
        str.substring(0, position) + ch + str.substring(position + 1)
    } else {
        str.substring(0, position) + ch
    }
}

private fun rep(str: String):String {
    return str.replace(" ",":")
}

