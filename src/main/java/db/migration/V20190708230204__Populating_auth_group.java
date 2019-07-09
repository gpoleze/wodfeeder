package db.migration;

import com.gabrielpf.wodfeeder.model.auth.AuthGroupEnum;
import org.flywaydb.core.api.migration.BaseJavaMigration;
import org.flywaydb.core.api.migration.Context;

import java.sql.Statement;

public class V20190708230204__Populating_auth_group extends BaseJavaMigration {

	@Override
	public void migrate(Context context) throws Exception {
		var sql = "INSERT INTO auth_group (name) VALUES ('%s')";

		for (AuthGroupEnum value : AuthGroupEnum.values()) {
			String format = String.format(sql, value);
			System.out.println(format);
			try (Statement statement = context.getConnection().createStatement()) {
				statement.executeUpdate(format);
			}
		}
	}
}