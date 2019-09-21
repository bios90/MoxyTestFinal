package com.dimfcompany.moxytest5.base

class Constants
{
    companion object
    {
        //        const val BASE_URL = "http://192.168.1.67/alisa2/"
        //        const val BASE_URL = "http://192.168.8.101/alisa2/"
        const val BASE_URL = "https://ak-russia.ru/"
        const val BASE_URL_PUBLIC = BASE_URL + "public/"
        const val BASE_URL_STORAGE = BASE_URL_PUBLIC + "storage/"
        const val BASE_URL_TEMPLATE_LOGOS = BASE_URL_STORAGE + "template_logos/"
        const val BASE_URL_DOCUMENTS = BASE_URL_STORAGE + "documents/"
        const val BASE_URL_INFO_FILES = BASE_URL_STORAGE + "info_files/"
        const val URL_REGISTER = "register/"
        const val URL_LOGIN = "login/"
        const val URL_FORGOT_PASS = "forgotpass/"
        const val URL_GET_ALL_TEMPLATES = "get_all_templates"
        const val URL_GET_ALL_RESTARAUNTS = "https://ak-hr.ru/get_all_restaraunts"
        const val URL_GET_ALL_USERS = "get_all_users"
        const val URL_MAKE_SEARCH = "make_search"
        const val URL_GET_RESTARAUNT_BY_ID = "https://ak-hr.ru/get_full_restaraunt"

        const val MY_SHARED_PREFS = "My_Shared_Prefs"
        const val FB_TOKEN = "Fb_Token"
        const val CURRENT_USER = "Current_User"
        const val FOLDER_TEMP_FILES = "temp_files"
        const val EXTANSION_PNG = "png"
        const val EXTANSION_PDF = "pdf"

        val ROLES = listOf("Менеджер", "Директор", "Зам.директора", "Территориальный управляющий", "SN. Территориальный управляющий", "Операционный директор", "Техник", "Инженер", "HR тренинг менеджер", "E.M.T", "R.O.C.C аудитор")

        val EXTRA_REGISTER_SUCCESS = "Extra_Register_Success"
        val EXTRA_MODEL_SEARCH = "Extra_Model_Search"

        val RQ_REGISTER_PAGE = 8999
        val RQ_SEARCH_DIALOG = 9000
        val RQ_CAMERA = 9001
        val RQ_GALLERY = 9002
    }
}