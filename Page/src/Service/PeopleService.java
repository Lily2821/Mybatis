package Service;

import java.io.IOException;

import pojo.PageInfo;

public interface PeopleService {
	PageInfo showPage(int pageSize,int pageNumber) throws IOException;
}
