package home.learn.hmt.lunar_app.utils

import home.learn.hmt.lunar_app.R

const val DAYS_COUNT = 42
const val LOCAL_TIMEZONE = 7.0
const val PI = Math.PI
const val NUMBER_OF_WEEKS_IN_MONTH = 6
const val NUMBER_OF_DAYS_IN_WEEK = 7
const val DATE_FORMAT = "MMM yyyy"
const val FORMAT_TIME_24 = "HH:mm:ss"
const val DD_MM_YYYY = "dd/MM/yyyy"
const val YYYY = "yyyy"

val SUNLONG_MAJOR = arrayOf(
    19 * PI / 12,
    5 * PI / 3, 7 * PI / 4, 11 * PI / 6, 23 * PI / 12, 0.0, PI / 12,
    PI / 6, PI / 4, PI / 3, 5 * PI / 12, PI / 2, 7 * PI / 12,
    2 * PI / 3, 3 * PI / 4, 5 * PI / 6, 11 * PI / 12, PI, 13 * PI / 12,
    7 * PI / 6, 5 * PI / 4, 4 * PI / 3, 17 * PI / 12, 3 * PI / 2
)

val SAO = arrayOf(
    "14. Bich (thuy)",
    "15. Khue (moc)", "16. Lau (kim)", "17. Vi (Tho)",
    "18. Mao (nhat)", "19. Tat (nguyet)", "20. Chuy (hoa)",
    "21. Sam (thuy)", "22. Tinh (moc)", "23. Quy (kim)",
    "24. Lieu (tho)", "25. Tinh (nhat)", "26. Truong (nguyet)",
    "27. Du (hoa)", "28. Chan (thuy)", "1. Giac (moc)",
    "2. Cang (kim)", "3. De (tho)", "4. Phong (nhat)",
    "5. Tam (nguyet)", "6. Vi (hoa)", "7. Co (thuy)", "8. Dau (moc)",
    "9. Nguu (kim)", "10. Nu (tho)", "11. Hu (nhat)",
    "12. Nguy (nguyet)", "13. That (hoa)"
)

val SAOTOT = arrayOf(
    "Thien Duc", "Nguyet Duc",
    "Thien Giai", "Thien Hy", "Thien Quy", "Tam Hop", "Sinh Khi",
    "Thien Thanh", "Thien Quan", "Loc Ma", "Phuc Sinh", "Giai Than",
    "Thien An"
)

val SAOXAU = arrayOf(
    "Thien Cuong", "Thu Tu",
    "Dai Hao\tTu Khi\tQuan Phu", "Tieu Hao", "Sat Chu", "Thien Hoa",
    "Dia Hoa", "Hoa Tai", "Nguyet Pha", "Bang Tieu Ngoa Giai",
    "Tho Cam", "Tho Ky\tVang Vong", "Co Than", "Qua Tu", "Trung Tang",
    "Trung Phuc"
)

val TIETKHI = arrayOf(
    "Tieu han", "Dai han", "Lap xuan", "Vu thuy", "Kinh trap", "Xuan phan",
    "Thanh minh", "Coc vu", "Lap ha", "Tieu man", "Mang chung", "Ha chi", "Tieu thu", "Dai thu",
    "Lap thu", "Xu thu", "Bach lo", "Thu phan", "Han lo", "Suong gian", "Lap dong", "Tieu tuyet",
    "Dai tuyet", "Dong chi"
)

val TRUC = arrayOf(
    "Truc kien", "Truc tru", "Truc man", "Truc binh", "Truc dinh", "Truc chap",
    "Truc pha", "Truc nguy", "Truc thanh", "Truc thu", "Truc khai", "Truc be"
)

val GIO = arrayOf(
    "23h-1h", "1h-3h", "3h-5h",
    "5h-7h", "7h-9h", "9h-11h",
    "11h-13h", "13h-15h", "15h-17h",
    "17h-19h", "19h-21h", "21h-23h"
)

val THU = arrayOf(
    "Chủ Nhật", "Thứ Hai", "Thứ Ba",
    "Thứ Tư", "Thứ Năm", "Thứ Sáu", "Thứ Bảy"
)

val CHI = arrayOf(
    "Tý", "Sửu", "Dần",
    "Mão", "Thìn", "Tỵ",
    "Ngọ", "Mùi", "Thân",
    "Dậu", "Tuất", "Hợi"
)

val CAN = arrayOf(
    "Giáp", "Ất", "Bính", "Đinh",
    "Mậu", "Kỷ", "Canh", "Tân", "Nhâm", "Qúy"
)

val MONTH = arrayOf(
    "Tháng 1", "Tháng 2", "Tháng 3",
    "Tháng 4", "Tháng 5", "Tháng 6", "Tháng 7", "Tháng 8", "Tháng 9", "Tháng 10", "Tháng 11",
    "Tháng 12"
)


val IMAGE_FOX = arrayOf(
    R.drawable.bg_fox_1, R.drawable.bg_fox_2,
    R.drawable.bg_fox_3, R.drawable.bg_fox_4,
    R.drawable.bg_fox_5, R.drawable.bg_fox_6,
    R.drawable.bg_fox_7, R.drawable.bg_fox_8,
    R.drawable.bg_fox_9, R.drawable.bg_fox_10
)

val folks = arrayListOf<String>(
    "Khó mà biết lẽ biết trời \n" +
            "Biết ăn, biết ở hơn người giàu sang",
    "Khúc sông bên lở bên bồi,\n" +
            "Bên lở lở mãi, bên bồi bồi thêm",
    "Con cháu mà dại thì hại ông cha.",
    "Mấy ai biết lúa von, mấy ai biết con hư.",
    "Cha mẹ sinh con, trời sinh tính.",
    "Chim khôn tiếc lông, người khôn tiếc lời",
    "Năng ăn hay đói, năng nói hay lầm",
    "Miếng ngon nhớ lâu \nLời đau nhớ đời",
    "Cây muốn lặng, gió chẳng dừng",
    "Biết thì thưa thốt\nKhông biết dựa cột mà nghe",
    "Tiền bạc đi trước\nMực thước đi sau",
    "Xới cơm thì xới lòng ta \n So đũa thì phải so ra lòng người",
    "Cười người chớ vội cười lâu \n" +
            "Cười người hôm trước hôm sau người cười",
    "Làm người chẳng ăn chẳng chơi,\nKhư khư giữ lấy của trời làm chi.",
    "Uống nước nhớ nguồn.",
    "Ăn quả nhớ kẻ trồng cây",
    "Anh em trong nhà, đóng cửa dạy nhau.\nAnh em thuận hòa là nhà có phúc.",
    "Thứ nhất thì tu tại gia, \n" +
            "Thứ nhì tu chợ, thứ ba tu chùa.",
    "Muốn máy thì phải có kim, \n" +
            "Muốn hay ắt phải đi tìm người xưa.",
    "Đò dọc phải tránh đò ngang, \n" +
            "Ngụ cư phải tránh dân làng cho xa.",
    "Cơm ăn ba bữa thì cho, \n" +
            "Gạo mượn sét chén, xách mo đi đòi.",
    "Có bột mới khuấy nên hồ, \n" +
            "Có vôi có gạch mới tô nên nhà.",
    "Lên non cho biết non cao, \n" +
            "Xuống biển cầm sào cho biết cạn sâu.",
    "Gần ba mươi tuổi chớ mừng, \n" +
            "Khó ba mươi tuổi con đừng vội lo."
)