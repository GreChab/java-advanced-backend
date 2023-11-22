module jmp.cloud.service.impl {
    requires transitive jmp.service.api;
    requires jmp.dto;
    provides com.epam.service.Service with com.epam.service.impl.ServiceImpl;
}