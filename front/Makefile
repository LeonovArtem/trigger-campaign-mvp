.PHONY: build help

install: ../front/package.json ## install dependencies
	@if [ "$(CI)" != "true" ]; then \
		echo "Full install..."; \
		yarn; \
	fi
	@if [ "$(CI)" = "true" ]; then \
		echo "Frozen install..."; \
		yarn --frozen-lockfile; \
	fi

run: ## run dev
	@yarn run


build-demo: ## compile App to static js
	@yarn build


lint: ## lint the code and check coding conventions
	@echo "Running linter..."
	@yarn lint

prettier: ## prettify the source code using prettier
	@echo "Running prettier..."
	@yarn prettier
