package home.learn.hmt.lunar_app.utils

import android.content.Context
import android.graphics.Point
import android.view.WindowManager
import home.learn.hmt.lunar_app.R
import home.learn.hmt.lunar_app.model.CalendarDate
import home.learn.hmt.lunar_app.model.DayMonthYear
import java.text.SimpleDateFormat
import java.util.*

fun monthToString(month: Int): String = MONTH[month]

fun dayOfWeekToString(day: Int): String = THU[day]
fun isToday(mYear: Int, mMonth: Int, mDate: Int): Boolean {
    val today = Calendar.getInstance()
    return mYear == today.get(Calendar.YEAR) &&
            mMonth == today.get(Calendar.MONTH) &&
            mDate == today.get(Calendar.DAY_OF_MONTH)
}

fun isDateEqual(date1: CalendarDate, date2: CalendarDate): Boolean {
    return date2.mYear == date2.mYear &&
            date2.mMonth == date2.mMonth &&
            date2.mDay == date2.mDay
}

fun getDayOfWeek(dmy: DayMonthYear): String {
    val dayFormat = dmy.day.toString() + "/" + dmy.month.toString() + "/" + dmy.year.toString()
    val simpleDateFormat = SimpleDateFormat(DD_MM_YYYY)
    val date = simpleDateFormat.parse(dayFormat)
    val day = date.day
    return dayOfWeekToString(day)
}

private fun getPointSize(context: Context): Point {
    val wm = context.getSystemService(Context.WINDOW_SERVICE) as WindowManager
    val display = wm.defaultDisplay
    val size = Point()
    display.getSize(size)
    return size
}

fun convertHourToChi(hour: Int): String {
    return when (hour) {
        in 1.until(3) -> CHI[1]
        in 3.until(5) -> CHI[2]
        in 5.until(7) -> CHI[3]
        in 7.until(9) -> CHI[4]
        in 9.until(11) -> CHI[5]
        in 11.until(13) -> CHI[6]
        in 13.until(15) -> CHI[7]
        in 15.until(17) -> CHI[8]
        in 17.until(19) -> CHI[9]
        in 19.until(21) -> CHI[10]
        in 21.until(23) -> CHI[11]
        else -> CHI[0]
    }
}

fun Date.convertDataToCalendar(): Calendar {
    val cal = Calendar.getInstance()
    cal.time = this
    return cal
}

fun slideImagesStar() = arrayListOf<Int>(
    R.drawable.ic_bach_duong, R.drawable.ic_kim_nguu,
    R.drawable.ic_songtu, R.drawable.ic_cu_giai,
    R.drawable.ic_su_tu, R.drawable.ic_xu_nu,
    R.drawable.ic_thien_binh, R.drawable.ic_ho_cap,
    R.drawable.ic_nhan_ma, R.drawable.ic_ma_ket,
    R.drawable.ic_bao_binh, R.drawable.ic_song_ngu
)

fun slideDateStar() = arrayListOf<String>(
    "Bạch Dương\n(21/3 - 19/4)", "Kim Ngưu\n(20/4 - 20/5)",
    "Song Tử\n(21/5 - 21/6)", "Cự Giải\n(22/6 - 22/7)",
    "Sư Tử\n(23/7 - 22/8)", "Xử Nữ\n(23/8 - 22/9)",
    "Thiên Bình\n(23/9 - 23/10)", "Hổ Cáp\n(24/10 - 21/11)",
    "Nhân Mã\n(22/11 - 21/12)", "Ma Kết\n(22/12 - 19/1)",
    "Bảo Bình\n(20/1 - 18/2)", "Song Ngư\n(19/2 - 20/3)"
)


//https://www.msn.com/vi-vn/lifestyle/lifestylenews/%C4%91i%E1%BB%83m-y%E1%BA%BFu-l%E1%BB%9Bn-nh%E1%BA%A5t-c%E1%BB%A7a-12-cung-ho%C3%A0ng-%C4%91%E1%BA%A1o-v%C3%A0-c%C3%A1ch-kh%E1%BA%AFc-ph%E1%BB%A5c/ar-BBOhH8b
fun slideContentStar() = arrayListOf<String>(
    "Điểm yếu lớn nhất của Bạch Dương chắc chắn là mua sắm vô tội vạ. " +
            "Chỉ cần hứng lên là bạn có thể sẵn sàng chi tiền ngay lập tức mà không suy nghĩ gì nhiều. " +
            "Vì thế nên hậu quả là bạn có quá nhiều đồ đạc và tiền bạc thì cứ không cánh mà bay.\n\n" +
            "Cách khắc phục: Phải thật bình tĩnh. " +
            "Ngoài ra cung hoàng đạo này cũng có thể “đóng băng” thẻ ngân hàng của mình bằng nhiều cách khác nhau bởi khi không tiện tay là quẹt thẻ nữa thì chắc chắn bạn cũng sẽ tiết kiệm được ít nhiều. " +
            "Dĩ nhiên tuy thẻ không lăm le trong tay nhưng cũng không khó để tiêu tiền vì chắc chắn các thông tin đó đã được lưu trữ ở những nơi khác nhau, tuy nhiên nếu mỗi lần mua sắm đều không thấy thẻ thì cũng là một sự nhắc nhở rằng bạn cần kiểm soát thói quen chi tiêu, mua sắm của mình tốt hơn.",
    "Bướng bỉnh là một trong những nét tính cách đặc trưng và cũng là nhược điểm lớn đối với Kim Ngưu. " +
            "Dù tất cả mọi người đều có cùng một đáp án giống nhau thì chắc chắn Kim Ngưu vẫn nhất nhất tin tưởng vào sự lựa chọn của mình. " +
            "Để thuyết phục được Kim Ngưu rằng đó là đáp án sai thật sự khó như lên trời hái sao, họ chỉ công nhận rằng mình sai khi tự mình nghiên cứu và tìm được thông tin chính xác hơn.\n\n" +
            "Cách khắc phục: Hãy tỏ ra mình là người biết lắng nghe. " +
            "Lắng nghe không có nghĩa là bạn đồng tình với quan điểm của người nói tuy nhiên Kim Ngưu cũng cần phải nhận thức được rằng không phải cuộc tranh luận nào cũng đi đến kết luận rằng một bên đúng, một bên sai. " +
            "Vì thế để không gây mất đoàn kết nội bộ thì đôi lúc bạn nên bình tĩnh và dĩ hòa vi quý hơn.",
    "Điểm yếu của Song Tử có lẽ là ham vui. " +
            "Một khi đã nhập cuộc thì dường như bạn sẽ quên hết cả không gian, thời gian và không biết điểm dừng là lúc nào. " +
            "Tuy nhiên sau đó thì Song Tử cũng cảm thấy khá hối tiếc vì sau một đêm chơi bời mệt nghỉ bạn sẽ đến công sở với bộ dạng không thể mệt mỏi hơn.\n\n" +
            "Cách khắc phục: Không phải chỉ những người chịu chơi nhất mới là người tận hưởng trọn vẹn bữa tiệc nhất. " +
            "Những lần tới bạn hãy thử dừng lại ở tăng một, tăng hai mà xem, bạn sẽ bất ngờ vì mình vẫn cảm thấy rất vui vẻ và hào hứng.",
    "Cự Giải lúc nào cũng quá hi sinh vì người khác. " +
            "Bạn luôn muốn làm hài lòng người xung quanh và sẵn sàng hi sinh bản thân để mọi người được vui vẻ, thoải mái. " +
            "Có một người bạn Cự Giải giống như có một chiếc áo ấm mùa đông hay một cái gối để ta vùi mặt vào khóc khi buồn vậy. " +
            "Tuy rằng điều đó khiến Cự Giải rất được mọi người xung quanh yêu quý nhưng đôi lúc nó cũng tạo nên một áp lực vô hình cho bạn.\n\n" +
            "Cách khắc phục: Bên cạnh việc làm vừa lòng thế giới xung quanh thì Cự Giải cũng nên quan tâm nhiều hơn đến những mong muốn của bản thân. " +
            "Khi cảm thấy quá mệt mỏi thì đừng ép bản thân mình quá mà hãy nghỉ ngơi, chỉ khi bình tâm suy nghĩ bạn mới lại tìm được sự kết nối với thế giới.",
    "Hám danh có vẻ là một từ khá nặng nề nhưng Sư Tử là người ưa hình thức và luôn bị mê hoặc bởi tiền tài, danh vọng. " +
            "Trong bất kì hoàn cảnh nào Sư Tử cũng không thể cưỡng lại những thứ hào nhoáng, xa xỉ, mới nhất, độc nhất vì chỉ những thứ đó mới thỏa mãn được tính trọng hình thức của cung hoàng đạo này.\n\n" +
            "Cách khắc phục: Thử trước khi mua. " +
            "Việc thích sắm cho mình những thứ đồ mới nhất, đắt giá nhất không có gì là sai cả tuy nhiên thay vì trưng nó lên như một cách thể hiện đẳng cấp thì bạn hãy mua những thứ mình thật sự thích và thật sự phù hợp với bản thân. " +
            "Bên cạnh đó, Sư Tử hoàn toàn có thể tìm mua những thứ bạn thích từ nhiều nguồn để có sự so sánh về giá và có được món đồ đó với giá hợp lý nhất.",
    "Điểm yếu lớn nhất của Xử Nữ là sự đơn điệu. Điều đó thể hiện ngay từ tủ quần áo của bạn: toàn áo phông trắng và quần jeans. " +
            "Không phải Xử Nữ lười thay đổi mà chỉ đơn giản là mỗi khi thích thứ gì đó bạn sẽ mua rất nhiều và đủ để mặc cả năm, chính vì thế nên tủ đồ của Xử Nữ khá đơn điệu vì chỉ theo một phong cách nhất định.\n\n" +
            "Cách khắc phục: Thử nghiệm những điều mới mẻ! Tại sao không? Hãy thử khoác lên mình một bộ đồ bạn chưa từng nghĩ đến việc mua nó chứ đừng nói đến mặc, đi một đôi giày khác với phong cách bình thường hoặc đơn giản chỉ là thay đổi màu sắc cho tủ đồ thêm sinh động. " +
            "Đó cũng là một phương pháp hiệu quả giúp cho mỗi ngày của bạn đều tràn đầy màu sắc.",
    "Đôi mắt là cửa sổ của tâm hồn và Thiên Bình dường như bị ám ảnh về sự hoàn hảo của đôi mắt. Lúc nào bạn cũng phải trang điểm mắt thật kĩ và gần như chẳng có loại mascara nào mà Thiên Bình chưa từng thử qua cả.\n\n" +
            "Cách khắc phục: Hãy trân trọng vẻ đẹp tự nhiên của bản thân! Làm đẹp là nhu cầu thiết yếu của mỗi người nhưng đừng để mình bị phụ thuộc vào nó. " +
            "Bạn hoàn toàn có thể thử những cách trang điểm tự nhiên hơn để không che mất vẻ đẹp vốn có của đôi mắt mình đồng thời vẫn cảm thấy tự tin khi ra ngoài.",
    "Màu mè là từ rất phù hợp để chỉ Bọ Cạp. Dường như bạn là con người rất sôi động, yêu thích màu sắc và sự thay đổi, vậy nên chẳng có màu sắc nào là không hợp mắt Bọ Cạp và cũng chính vì thế nên đôi lúc nhìn bạn hơi giống “đèn giao thông” một chút.\n\n" +
            "Cách khắc phục: Thay vì trang hoàng nhà cửa bằng tất cả những gam màu không mấy liên quan đó thì Bọ Cạp có thể thử một cách khác để đổi mới không gian sống ví dụ như nến thơm hay treo tranh, ảnh xem sao. Một cây nến với mùi thơm dễ chịu sẽ khiến bạn cảm thấy bình yên, thanh thản hơn rất nhiều.",
    "Mạo hiểm là nét tính cách rất nổi bật của Nhân Mã. Bạn là người tự do, phóng khoáng, ưu phiêu lưu và luôn sẵn sàng xách balo lên và đi bất kì lúc nào. Nhân Mã cũng chuẩn bị rất kĩ lưỡng cho từng chuyến đi của bản thân, bạn mang lỉnh kỉnh không biết bao nhiêu là đồ đạc nhưng vấn đề duy nhất phát sinh đó là bạn chẳng bao giờ biết mình đã để mọi thứ vào đâu. " +
            "Vốn không phải người ngăn nắp, đây là điểm yếu rất lớn của Nhân Mã.\n\n" +
            "Cách khắc phục: Lên kế hoạch kĩ và chỉ mang những thứ cần thiết. Khi bạn giới hạn được những thứ mình cần thì thứ nhất là sẽ giảm số lượng đồ cần mang, bạn không cần phải mệt mỏi mang vác đủ thứ nữa và thứ hai là ít đồ đồng nghĩa với việc không cần mang quá nhiều vali, balo, túi xách để đựng và bạn cũng sẽ không rơi vào tình trạng phải lục tung tất cả mọi thứ chỉ để tìm một thứ nữa.",
    "Vốn là người cẩn thận và lo xa nên Ma Kết lúc nào cũng chuẩn bị đầy đủ, thậm chí là thừa mứa những nhu yếu phẩm của cuộc sống. " +
            "Vậy nên đừng cố chèo kéo Ma Kết mua đồ vì bạn luôn có sẵn rất nhiều kem đánh răng, ngũ cốc, giấy, đồ ăn khô,… cho bất kì trường hợp nào. Chỉ có điều liệu bạn có nhớ lần cuối mình mua một thứ gì đó thú vị hoặc tự thưởng cho bản thân là khi nào không? " +
            "Chắc hẳn Ma Kết đã quá tiết kiệm mà quên mất những món quà tinh thần đó rồi.\n\n" +
            "Cách khắc phục: Đơn giản thôi, hãy đi ra một cửa hàng bạn yêu thích và mua cho mình một món đồ bạn cảm thấy không thể về nhà mà thiếu nó. " +
            "Đừng lo rằng điều đó sẽ khiến bạn chi tiêu vô độ, đây chỉ là một minh chứng cho thấy Ma Kết nên biết tự yêu thương bản thân mình vào những lúc phù hợp mà thôi.",
    "Đôi lúc Bảo Bình tỏ ra quá thiển cận. Bạn sẽ làm tất cả những gì mình cho là cần thiết trong thời điểm hiện tại mà không cần biết tương lai sẽ như thế nào. " +
            "Lên kế hoạch dù chỉ cho ngày mai thôi cũng là một việc tương đối khó khăn với Bảo Bình.\n\n" +
            "Cách khắc phục: Lên kế hoạch và tuân thủ chặt chẽ kế hoạch đó. " +
            "Bảo Bình nên tập lên kế hoạch cho các hoạt động của bản thân và nhắc nhở mình những việc cần làm mỗi khi bắt đầu một ngày mới. " +
            "Một bí quyết quan trọng để sống có kế hoạch đó là quyết đoán khi gặp phải những tình huống phát sinh.",
    "Quá nhạy cảm là điểm yếu lớn nhất của Song Ngư vì đôi lúc bạn bị cuốn vào những câu chuyện rắc rối trong cuộc sống của người khác và dễ cảm thấy bi quan. " +
            "Điều này cũng khiến Song Ngư dễ xen vào việc của người khác chỉ vì bạn quá cảm thông với họ và cho rằng mình phải làm gì đó.\n\n" +
            "Cách khắc phục: Tập xem nhiều phim tâm lý xã hội. " +
            "Những bộ phim với các tình huống dở khóc dở cười, hài kịch có bi kịch có sẽ khiến bạn dần quen với việc không để bản thân lún sâu vào việc không phải của mình, từ đó bạn cũng sẽ kiểm soát cảm xúc của mình tốt hơn."
)




