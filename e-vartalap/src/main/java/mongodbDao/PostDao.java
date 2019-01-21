package mongodbDao;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.app.evartalap.evartalap.pojos.mongodbpojos.Post;

public interface PostDao extends MongoRepository<Post,post_id>{

}
