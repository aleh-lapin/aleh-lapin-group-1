package jmp.module14.data;

import java.util.Collection;

import jmp.module14.data.Resource.ResourceState;
import jmp.module14.model.Member;

public class MemberRepository extends UnitDaoImpl<Member> implements IRepository<Member>, Resource {
	
	private ResourceState state;
	
	public MemberRepository () {
		super(new Class<?>[]{Member.class, Member[].class});
//		Member t1 = new Member();
//		t1.setBallance(200.0D);
//		t1.setEmail("admin@admin.com");
//		t1.setName("Person1");
//		t1.setOrderCount(2L);
//		t1.setPhoneNumber("3578670");
//		this.pushEntity(t1);
	}
	
	public static void main(String[] args) {
		System.out.println(1);
		Member t1 = new Member();
		t1.setBallance(200.0D);
		t1.setEmail("admin@admin.com");
		t1.setName("Person1");
		t1.setOrderCount(2L);
		t1.setPhoneNumber("3578670");
		
		IRepository<Member> repository = new MemberRepository();
		repository.pushEntity(t1);
		Member t2 = repository.obtainEntity("1");
		System.out.println(1 + t2.getPhoneNumber());
		//repository.destroyEntity(t2);
		for(Member t : repository.watchEntities()) {
			System.out.println(t.getPhoneNumber());
		}
	}

	@Override
	public void pushEntity(Member element) {
		insert(element);
	}

	@Override
	public Member obtainEntity(String expression) {
		return read(expression);
	}

	@Override
	public Member modifyEntity(Member element) {
		return update(element);
	}

	@Override
	public void destroyEntity(Member element) {
		delete(element);
	}

	@Override
	public Collection<Member> watchEntities() {
		return list();
	}
	
	@Override
	public String getName() {
		return getClass().getSimpleName();
	}

	@Override
	public void prepare() {
		state = ResourceState.PREPARED;
		cacheItem();
	}

	@Override
	public void commit() {
		state = ResourceState.COMMITED;
		clearCache();
	}

	@Override
	public void recover() {
		state = ResourceState.RECOVERED;
		restoreCacheItem();
	}

	@Override
	public ResourceState getState() {
		return state;
	}
	
	@Override
	public void setState(ResourceState state) {
		this.state = state;		
	}

}
