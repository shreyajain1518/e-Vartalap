package mongodbDao;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.app.evartalap.evartalap.pojos.mongodbpojos.Comment;


public interface CommentDao extends MongoRepository<Comment,Integer>
{

}
