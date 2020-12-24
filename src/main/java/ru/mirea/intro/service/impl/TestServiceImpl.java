package ru.mirea.intro.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ru.mirea.intro.dao.BookDao;
import ru.mirea.intro.dao.RequestDAO;
import ru.mirea.intro.dao.repository.RequestRepository;
import ru.mirea.intro.exception.NoSuchRequest;
import ru.mirea.intro.mapper.RequestMapper;
import ru.mirea.intro.service.TestService;
import ru.mirea.intro.service.model.Request;
import ru.mirea.intro.web.to.RequestDto;

import java.util.Optional;

@Service
public class TestServiceImpl implements TestService {
    @Autowired
    RequestRepository requestRepository;

    @Override
    public Request testServiceGetMethod(Long id) throws NoSuchRequest {
        Optional<RequestDAO> requestDAO = requestRepository.findById(id);
        if (requestDAO.isPresent()) {
            return RequestMapper.REQUEST_MAPPER.requestDAOToRequest(requestDAO.get());
        }
        throw new NoSuchRequest();
    }

    @Override
    public String testServicePostMethod(Request request) {
        RequestDAO requestDAO = RequestMapper.REQUEST_MAPPER.requestToRequestDAO(request);
        requestDAO.getBookDaoList().forEach(bookDao -> bookDao.setRequestDao(requestDAO));
//        for (BookDao bookDao : requestDAO.getBookDaoList()) {
//            bookDao.setRequestDao(requestDAO);
//        }
        requestRepository.save(requestDAO);
        return "Successfully inserted row!";
    }

    @Override
    public String testServiceDeleteMethod(Long id) throws NoSuchRequest{
        if (requestRepository.existsById(id)){
            requestRepository.deleteById(id);
            return "Removal is successful!";
        }
        throw new NoSuchRequest();
    }

    @Override
    public String testServicePutMethod(Request request) throws NoSuchRequest {
        RequestDAO requestDAOToPut = RequestMapper.REQUEST_MAPPER.requestToRequestDAO(request);
        Long id = requestDAOToPut.getId();
        if (requestRepository.existsById(id))
        {
            requestDAOToPut.getBookDaoList().forEach(bookDao -> bookDao.setRequestDao(requestDAOToPut));
            requestRepository.save(requestDAOToPut);
            return "Database successfully updated!";
            /*
            Optional<RequestDAO> requestDAOFromDB = requestRepository.findById(id);
            for (BookDao book : requestDAOFromDB.get().getBookDaoList()) {
                book.
            }
            return null;
            */
        }
        else throw new NoSuchRequest();
    }
}