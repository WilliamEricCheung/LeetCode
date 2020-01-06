package tech.wec.Bash;

public class WordFrequency_192 {
    /*
    cat words.txt | xargs -n1 | sort | uniq -c | sort -nr | awk '{print $2 " " $1}'
    /////
    cat read file
    tokenize with line by line output
    sort the words to prepare for count -c
    output unique words with count (-c)
    sort in natural order (-n) descending (-r reverse)
    tokenize with awk to remove whitespace formatting and reverse the order given by count -c
     */
}
