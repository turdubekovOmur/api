package kg.cbk.api.service.impl;

import kg.cbk.api.entity.Request;
import kg.cbk.api.entity.dto.CheckResponseDto;
import kg.cbk.api.entity.dto.RequestDto;
import kg.cbk.api.entity.dto.SaveResponseDto;
import kg.cbk.api.entity.enums.Command;
import kg.cbk.api.exceptions.BadRequestException;
import kg.cbk.api.exceptions.NotFoundException;
import kg.cbk.api.repository.RequestRepository;
import kg.cbk.api.service.RequestService;
import kg.cbk.api.service.builder.CheckResponseBuilder;
import kg.cbk.api.service.builder.RequestDtoBuilder;
import kg.cbk.api.service.builder.SaveResponseBuilder;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
@Slf4j
public class RequestServiceImpl implements RequestService {

    private final RequestRepository repository;
    private final Logger logger = LoggerFactory.getLogger(RequestServiceImpl.class);

    @Override
    public Object check(Request request) {
        if (request.getCommand().equals(Command.CHECK)) {

            logger.trace("Поиск объекта в бд по ID = {} ", request.getId());

            if (repository.findById(request.getId()).isPresent()) {

                Request request1 = repository.getById(request.getId());
                CheckResponseBuilder checkResponse = new CheckResponseBuilder();
                CheckResponseDto dto = checkResponse.convertTo(request1);

                return dto;
            }
            logger.error("Не корректные команды: PAY/CHECK или данные!");
            return new BadRequestException("given object does not exists!");
        }
        return new NotFoundException("THE GIVEN OBJECT DOES NOT EXIST !");
    }


    public Object add(Request request) {

        if (request.getCommand().equals(Command.PAY)) {

            RequestDtoBuilder requestDtoBuilder = new RequestDtoBuilder();
            RequestDto requestDto = requestDtoBuilder.convertToDto(request);

            logger.info("Запись в базу данных");
            repository.save(request);
            return getResponse(requestDto);
        } else {
            logger.error("Не корректные команды: PAY/CHECK или данные!");
            return new BadRequestException("INVALID DATA");

        }
    }


    private SaveResponseDto getResponse(RequestDto requestDto) {

        logger.trace("Конвертирование запроса в ответ");
        SaveResponseBuilder responseConverter = new SaveResponseBuilder();

        return responseConverter.convertToXml(requestDto);

    }
}
