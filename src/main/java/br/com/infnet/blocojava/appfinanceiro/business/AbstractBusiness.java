package br.com.infnet.blocojava.appfinanceiro.business;

import java.lang.reflect.Field;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.MappedSuperclass;

import org.apache.commons.lang3.reflect.FieldUtils;

import br.com.infnet.blocojava.appfinanceiro.utils.ColumnHeader;
import br.com.infnet.blocojava.appfinanceiro.utils.ColumnMetadata;

@MappedSuperclass
public class AbstractBusiness {
	
	@Id
	@Column(name = "id")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}
	
	public static Map<String, ColumnMetadata> getFieldsToHeader(Class<?> negocioClass)
	{
		Field[] declaredFields = FieldUtils.getFieldsWithAnnotation(negocioClass, ColumnHeader.class);
		
		Map<String, ColumnMetadata> fieldsToHeader = Stream
		.of(declaredFields)
		.sorted((current, comparing) -> {
			
			int currentPosition = current.getAnnotation(ColumnHeader.class).position();
			int comparingPosition = comparing.getAnnotation(ColumnHeader.class).position();
			
			return currentPosition > comparingPosition ? 1 : -1;
			
		})
		.collect(
			Collectors.toMap(
				Field::getName, 
				field -> { 
					String name = field.getAnnotation(ColumnHeader.class).name();
					Class<?> type = field.getType();
					
					return new ColumnMetadata(name, type);
				}
			)
		);
		
		return fieldsToHeader;
		
	}
	
	public Object getFieldValue(String fieldName) 
	{
		
		try {
			
			List<Field> allFields = FieldUtils.getFieldsListWithAnnotation(this.getClass(), ColumnHeader.class);
			
			Optional<Field> possibleField = allFields.stream().filter(field -> field.getName().equals(fieldName)).findFirst();
			
			if(!possibleField.isPresent()) 
			{
				return "Unable to get value";
			}
			
			Field field = possibleField.get();
			
			boolean accessible = field.isAccessible();
			field.setAccessible(true);
			
			Object value = field.get(this);
			
			field.setAccessible(accessible);
			
			return value;
		} catch (IllegalArgumentException | IllegalAccessException | SecurityException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			
			return "Unable to get value";
		}
		
	}
	
	
}
