module jmp.cloud.service.impl {
    requires transitive jmp.service.api;
    requires jmp.dto;
    exports com.epam.service.impl;
    provides com.epam.service.Service with com.epam.service.impl.ServiceImpl;
}