package tech.wec.Bash;

public class TenthLine_195 {
    /*
    1. sed -n '10p' < file.txt
    2. awk 'NR==10' file.txt
    3. cat file.txt | awk '{if (NR==10){print $0}}'
    4.  cnt=0
        while read  LINE; do
	        if [ -z "$LINE" ]; then continue; fi
            if [ $cnt -eq 9 ]; then
                echo $LINE
            fi
            ((cnt++))
        done < file.txt
     */
}
