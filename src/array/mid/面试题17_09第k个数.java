package array.mid;

import java.util.HashSet;
import java.util.LinkedList;
import java.util.PriorityQueue;
import java.util.Set;

public class 面试题17_09第k个数 {
    public static void main(String[] args) {
        int number = getKthMagicNumber(5);
        System.out.println(number);
    }


    public static int getKthMagicNumber(int k) {
        int[] factors = {3, 5, 7};
        Set<Long> seen = new HashSet<Long>();
        PriorityQueue<Long> heap = new PriorityQueue<Long>();
        seen.add(1L);
        heap.offer(1L);
        int magic = 0;
        for (int i = 0; i < k; i++) {
            long curr = heap.poll();
            magic = (int) curr;
            for (int factor : factors) {
                long next = curr * factor;
                if (seen.add(next)) {
                    heap.offer(next);
                }
            }
        }
        return magic;
    }

//    public static int getKthMagicNumber(int k) {
//        int arr[] = {1,3,5,7,9,15,21,25,27,35,45,49,63,75,81,105,125,135,147,175,189,225,243,245,315,343,375,405,441,525,567,625,675,729,735,875,945,1029,1125,1215,1225,1323,1575,1701,1715,1875,2025,2187,2205,2401,2625,2835,3087,3125,3375,3645,3675,3969,4375,4725,5103,5145,5625,6075,6125,6561,6615,7203,7875,8505,8575,9261,9375,10125,10935,11025,11907,12005,13125,14175,15309,15435,15625,16807,16875,18225,18375,19683,19845,21609,21875,23625,25515,25725,27783,28125,30375,30625,32805,33075,35721,36015,39375,42525,42875,45927,46305,46875,50421,50625,54675,55125,59049,59535,60025,64827,65625,70875,76545,77175,78125,83349,84035,84375,91125,91875,98415,99225,107163,108045,109375,117649,118125,127575,128625,137781,138915,140625,151263,151875,153125,164025,165375,177147,178605,180075,194481,196875,212625,214375,229635,231525,234375,250047,252105,253125,273375,275625,295245,297675,300125,321489,324135,328125,352947,354375,382725,385875,390625,413343,416745,420175,421875,453789,455625,459375,492075,496125,531441,535815,540225,546875,583443,588245,590625,637875,643125,688905,694575,703125,750141,756315,759375,765625,820125,823543,826875,885735,893025,900375,964467,972405,984375,1058841,1063125,1071875,1148175,1157625,1171875,1240029,1250235,1260525,1265625,1361367,1366875,1378125,1476225,1488375,1500625,1594323,1607445,1620675,1640625,1750329,1764735,1771875,1913625,1929375,1953125,2066715,2083725,2100875,2109375,2250423,2268945,2278125,2296875,2460375,2470629,2480625,2657205,2679075,2701125,2734375,2893401,2917215,2941225,2953125,3176523,3189375,3215625,3444525,3472875,3515625,3720087,3750705,3781575,3796875,3828125,4084101,4100625,4117715,4134375,4428675,4465125,4501875,4782969,4822335,4862025,4921875,5250987,5294205,5315625,5359375,5740875,5764801,5788125,5859375,6200145,6251175,6302625,6328125,6751269,6806835,6834375,6890625,7381125,7411887,7441875,7503125,7971615,8037225,8103375,8203125,8680203,8751645,8823675,8859375,9529569,9568125,9646875,9765625,10333575,10418625,10504375,10546875,11160261,11252115,11344725,11390625,11484375,12252303,12301875,12353145,12403125,13286025,13395375,13505625,13671875,14348907,14467005,14586075,14706125,14765625,15752961,15882615,15946875,16078125,17222625,17294403,17364375,17578125,18600435,18753525,18907875,18984375,19140625,20253807,20420505,20503125,20588575,20671875,22143375,22235661,22325625,22509375,23914845,24111675,24310125,24609375,26040609,26254935,26471025,26578125,26796875,28588707,28704375,28824005,28940625,29296875,31000725,31255875,31513125,31640625,33480783,33756345,34034175,34171875,34453125,36756909,36905625,37059435,37209375,37515625,39858075,40186125,40353607,40516875,41015625,43046721,43401015,43758225,44118375,44296875,47258883,47647845,47840625,48234375,48828125,51667875,51883209,52093125,52521875,52734375,55801305,56260575,56723625,56953125,57421875,60761421,61261515,61509375,61765725,62015625,66430125,66706983,66976875,67528125,68359375,71744535,72335025,72930375,73530625,73828125,78121827,78764805,79413075,79734375,80390625,85766121,86113125,86472015,86821875,87890625,93002175,93767625,94539375,94921875,95703125,100442349,101269035,102102525,102515625,102942875,103359375,110270727,110716875,111178305,111628125,112546875,119574225,120558375,121060821,121550625,123046875,129140163,130203045,131274675,132355125,132890625,133984375,141776649,142943535,143521875,144120025,144703125,146484375,155003625,155649627,156279375,157565625,158203125,167403915,168781725,170170875,170859375,172265625,182284263,183784545,184528125,185297175,186046875,187578125,199290375,200120949,200930625,201768035,202584375,205078125,215233605,217005075,218791125,220591875,221484375,234365481,236294415,238239225,239203125,241171875,244140625,257298363,258339375,259416045,260465625,262609375,263671875,279006525,281302875,282475249,283618125,284765625,287109375,301327047,303807105,306307575,307546875,308828625,310078125,330812181,332150625,333534915,334884375,337640625,341796875,358722675,361675125,363182463,364651875,367653125,369140625,387420489,390609135,393824025,397065375,398671875,401953125,425329947,428830605,430565625,432360075,434109375,439453125,465010875,466948881,468838125,472696875,474609375,478515625,502211745,506345175,510512625,512578125,514714375,516796875,546852789,551353635,553584375,555891525,558140625,562734375,597871125,600362847,602791875,605304105,607753125,615234375,645700815,651015225,656373375,661775625,664453125,669921875,703096443,708883245,714717675,717609375,720600125,723515625,732421875,771895089,775018125,778248135,781396875,787828125,791015625,837019575,843908625,847425747,850854375,854296875,861328125,903981141,911421315,918922725,922640625,926485875,930234375,937890625,992436543,996451875,1000604745,1004653125,1008840175,1012921875,1025390625,1076168025,1085025375,1089547389,1093955625,1102959375,1107421875,1162261467,1171827405,1181472075,1191196125,1196015625,1205859375,1220703125,1275989841,1286491815,1291696875,1297080225,1302328125,1313046875,1318359375,1395032625,1400846643,1406514375,1412376245,1418090625,1423828125,1435546875,1506635235,1519035525,1531537875,1537734375,1544143125,1550390625,1640558367,1654060905,1660753125,1667674575,1674421875,1688203125,1708984375,1793613375,1801088541,1808375625,1815912315,1823259375,1838265625,1845703125,1937102445,1953045675,1969120125,1977326743,1985326875,1993359375,2009765625,2109289329,2126649735,2144153025};
//        return arr[k - 1];
//    }

    public static boolean isShuYinZi(int i) {
        boolean flag = false;
        while ( i > 0) {
            if (i == 1) {
                flag = true;
                break;
            }
            if (i % 3 == 0 ) {
                i /= 3;
            } else if (i % 5 == 0 ) {
                i /= 5;
            } else if (i % 7 == 0) {
               i /= 7;
            } else {
                flag = false;
                break;
            }
        }
        return flag;
    }
}
